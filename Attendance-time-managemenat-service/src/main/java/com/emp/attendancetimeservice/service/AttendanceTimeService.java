package com.emp.attendancetimeservice.service;

import java.util.List;

import com.emp.attendancetimeservice.dto.AttendanceTimeResponceDto;

public interface AttendanceTimeService {

	AttendanceTimeResponceDto addClockInTime(String empId);
	AttendanceTimeResponceDto addClockOutTime(String empId);
	
//	List<E>
	
}
