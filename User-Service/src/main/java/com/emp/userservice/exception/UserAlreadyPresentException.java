package com.emp.userservice.exception;

public class UserAlreadyPresentException extends RuntimeException{

	public UserAlreadyPresentException(String message) {
		super(message);
	}
}
