package com.prueba.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.prueba.domain.File;
import com.prueba.domain.FileRepository;
import com.prueba.domain.exception.FileNotFound;

@Service
public class FileService implements IFileService {

	@Autowired
	private FileRepository fileRepo;
	
	@Override
	public File searchFileId(Long fileId) throws FileNotFound {
		return fileRepo.findById(fileId).orElseThrow(()-> new FileNotFound(String.valueOf(fileId)));
	}

	@Override
	public Page<File> searchFiles(Pageable pageable) {
		return fileRepo.findAll(pageable);
	}

}
