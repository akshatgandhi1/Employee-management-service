package com.emp.performancereviewservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PerfomanceException.class)
	@ResponseStatus(code = HttpStatus.FOUND)
	public String PerformanceExceptionHandler(PerfomanceException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(EmployeeIsNotpresentException.class)
	@ResponseStatus(code = HttpStatus.FOUND)
	public String EmployeeIsNotpresentExceptionHandler(EmployeeIsNotpresentException ex) {
		return ex.getMessage();
	}
	 
}
