package com.prueba.domain.exception;

public class RegisterNotFound extends DomainError{
	
	private static final long serialVersionUID = 1L;

	public RegisterNotFound(String message) {
		super("Register record not found - ["+message+"]");
		
	}
}
