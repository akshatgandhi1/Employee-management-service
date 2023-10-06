package com.emp.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyPresentException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public String handleUserAlreadypresentException(UserAlreadyPresentException ex) {
		return ex.getMessage();
	}
}
