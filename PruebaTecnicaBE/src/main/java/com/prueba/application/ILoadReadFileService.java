package com.prueba.application;

import org.springframework.web.multipart.MultipartFile;

public interface ILoadReadFileService {
	
	public void readSaveResgister(String nameFile);
	
	public void loadFile(MultipartFile file);
	
	public void createStorer();

}
