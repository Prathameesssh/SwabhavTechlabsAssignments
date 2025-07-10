package com.aurionpro.BankAccount;

public class CustomException extends RuntimeException{

	private String message;

	public CustomException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
