package com.emp.attendancetimeservice.exception;

public class AttendanceNotFoundException extends RuntimeException{

	public AttendanceNotFoundException(String message) {
		super(message);
	}
}
