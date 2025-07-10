package com.aurionpro.collection.bookStore;

public class CustomException extends Exception {
	
	private String message;
	
	public CustomException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
