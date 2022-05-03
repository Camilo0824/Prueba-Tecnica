package com.prueba.domain.exception;

public class FileNotFound extends DomainError{

	private static final long serialVersionUID = 1L;

	public FileNotFound(String message) {
		super("File record not found - ["+message+"]");
		
	}
	
}
