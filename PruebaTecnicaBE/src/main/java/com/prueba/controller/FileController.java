package com.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.application.IFileService;
import com.prueba.domain.File;

@RestController
@CrossOrigin("http://localhost:4200")
public class FileController {

	@Autowired
	private IFileService iFileService;

	@GetMapping("/files")
	private ResponseEntity<Page<File>> buscarArchivos(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "fileId") String order,
			@RequestParam(defaultValue = "true") boolean asc) {
		Page<File> archivos = iFileService.searchFiles(PageRequest.of(page, size, Sort.by(order)));
		if (!asc) {
			archivos = iFileService.searchFiles(PageRequest.of(page, size, Sort.by(order).descending()));
		}
		return new ResponseEntity<Page<File>>(archivos, HttpStatus.OK);
	}
}
