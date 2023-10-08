package com.emp.attendancetimeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AttendanceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public String handleUserAlreadypresentException(AttendanceNotFoundException ex) {
		return ex.getMessage();
	}
}
