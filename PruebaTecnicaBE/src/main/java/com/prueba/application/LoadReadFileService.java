package com.prueba.application;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.prueba.domain.File;
import com.prueba.domain.FileRepository;
import com.prueba.domain.MessageResponse;
import com.prueba.domain.Register;
import com.prueba.domain.RegisterRepository;

@Service
public class LoadReadFileService implements ILoadReadFileService {

	@Autowired
	private FileRepository fileRepo;

	@Autowired
	private RegisterRepository registerRepo;

	private final Path path = Paths.get("FileUploaded");

	@Override
	public void readSaveResgister(String nameFile) {
		FileReader readerFile = null;
		CSVReader readerCSV = null;

		try {
			readerFile = new FileReader("E:FileUploaded\\" + nameFile);
			readerCSV = new CSVReader(readerFile);
			String[] dataCol = null;
			int counter = 0;
			File file = null;
			String message = "";
			int totalCol = 0;
			List<Register> registers = new ArrayList<Register>();

			try {
				while ((dataCol = readerCSV.readNext()) != null) {
					totalCol = dataCol.length;
					if (counter == 0) {
						for (int i = 0; i < dataCol.length; i++) {
							message += "| " + dataCol[i] + " ";
						}
					} else {
						String registerData = "";
						for (int m = 0; m < dataCol.length; m++) {
							registerData += "| " + dataCol[m];
						}
						Register registro = Register.createRegister(registerData);
						registers.add(registro);
					}
					counter++;
				}
			} catch (Exception e) {
				MessageResponse messageResponse = MessageResponse.createMessage("Error reading CSV file. Error");
				throw new Exception("" + messageResponse + ". Error[" + e.getMessage() + "]");
			}

			file = File.createFile(nameFile, totalCol, message, counter);
			fileRepo.save(file);

			for (Register register : registers) {
				register.setFile(file);
				System.out.println(register.getRegisterData());
				registerRepo.save(register);
			}

		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				readerFile.close();
				readerCSV.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}

	}

	@Override
	public void loadFile(MultipartFile file) {
		try {

			try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("E:FileUploaded"))) {
				for (Path fileData : stream) {
					String name = fileData.getFileName().toString();
					if (file.getOriginalFilename().equals(name)) {
						throw new RuntimeException("The file already exists");
					}
				}
			} catch (IOException | DirectoryIteratorException ex) {
				System.err.println(ex);
			}
			
			String formatFile = "";
			
			int i = file.getOriginalFilename().lastIndexOf('.');
			if (i > 0) {
				formatFile = file.getOriginalFilename().substring(i + 1);
			}
			if (!formatFile.equals("csv")) {
				throw new RuntimeException("Only .CSV files are accepted");
			} else {
				Files.copy(file.getInputStream(), this.path.resolve(file.getOriginalFilename()));
			}
		} catch (Exception e) {
			throw new RuntimeException("The file could not be stored. Error [" + e.getMessage() + " ]");
		}

	}

	@Override
	public void createStorer() {
		try {
			Files.createDirectories(path);
		} catch (IOException e) {
			throw new RuntimeException("Could not create directory to store files. Error [" + e.getMessage() + " ]");
		}

	}
}
