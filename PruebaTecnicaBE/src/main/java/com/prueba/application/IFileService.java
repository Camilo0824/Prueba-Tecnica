package com.prueba.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prueba.domain.File;
import com.prueba.domain.exception.FileNotFound;

public interface IFileService {
	
	public File searchFileId(Long fileId) throws FileNotFound;
	
	public Page<File> searchFiles(Pageable pageable);
}
