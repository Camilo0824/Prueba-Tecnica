package com.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prueba.application.ILoadReadFileService;
import com.prueba.domain.MessageResponse;

@RestController
@CrossOrigin("http://localhost:4200")
public class LoadReadFileController {

	@Autowired
	private ILoadReadFileService iLoadReadFileService;

	@PostMapping("/files/load")
	public ResponseEntity<MessageResponse> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			iLoadReadFileService.loadFile(file);
			iLoadReadFileService.readSaveResgister(file.getOriginalFilename());
			message = "The file was uploaded successfully: " + file.getOriginalFilename();
			MessageResponse messageResponse = MessageResponse.createMessage(message);
			return ResponseEntity.status(HttpStatus.OK).body(messageResponse);
		} catch (Exception e) {
			message = "Could not load file: " + file.getOriginalFilename() + "!. Error["+e.getMessage()+"]";
			MessageResponse messageResponse = MessageResponse.createMessage(message);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(messageResponse);
		}
	}

}
