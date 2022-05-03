package com.prueba.domain.exception;

public class DomainError extends Exception {

	private static final long serialVersionUID = 1L;

	public DomainError(String message) {
		super(message);
	}
}
