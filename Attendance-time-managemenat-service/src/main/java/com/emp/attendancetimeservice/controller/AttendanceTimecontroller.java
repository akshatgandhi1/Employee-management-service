package com.emp.attendancetimeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.attendancetimeservice.dto.AttendanceTimeRequestDto;
import com.emp.attendancetimeservice.dto.AttendanceTimeResponceDto;
import com.emp.attendancetimeservice.service.AttendanceTimeService;

@RestController
@RequestMapping("/api/Attendance")
public class AttendanceTimecontroller {
	
	@Autowired
	private AttendanceTimeService attendanceTimeService;
	
	@PostMapping("/clock-in")
	public AttendanceTimeResponceDto getClockInTime() {
		AttendanceTimeRequestDto attendanceTimeRequestDto=new AttendanceTimeRequestDto();
		attendanceTimeRequestDto.setEmpId("123456");
		String empId= attendanceTimeRequestDto.getEmpId();
	return 	attendanceTimeService.addClockInTime(empId);
	}
	
	@PostMapping("/clock-out")
	public AttendanceTimeResponceDto getClockOutTime() {
		AttendanceTimeRequestDto attendanceTimeRequestDto=new AttendanceTimeRequestDto();
		attendanceTimeRequestDto.setEmpId("123456");
		String empId= attendanceTimeRequestDto.getEmpId();

	return 	attendanceTimeService.addClockOutTime(empId);
	}

}
