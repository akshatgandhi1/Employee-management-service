package com.emp.attendancetimeservice.service;

import java.util.List;

import com.emp.attendancetimeservice.dto.AttendanceTimeRequestDto;

public interface AttendanceTimeService {

	AttendanceTimeRequestDto addClockInTime(String empId);
	AttendanceTimeRequestDto addClockOutTime(String empId);
	
//	List<E>
	
}
