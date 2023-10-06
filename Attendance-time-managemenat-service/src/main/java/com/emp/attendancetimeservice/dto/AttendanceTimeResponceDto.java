package com.emp.attendancetimeservice.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceTimeResponceDto {
	
	private String attendanceId;
	private String empId;
	private LocalDate date;
	private LocalTime clockIn;
	private LocalTime clockOut;
	private String totalHours;

}
