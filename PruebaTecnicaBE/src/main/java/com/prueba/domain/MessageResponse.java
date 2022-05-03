package com.prueba.domain;

public class MessageResponse {
	private String message;

	private MessageResponse(String mensaje) {
		this.message = mensaje;
	}
	
	public static MessageResponse createMessage(String message) {
		return new MessageResponse(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
