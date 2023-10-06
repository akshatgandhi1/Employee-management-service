package com.emp.attendancetimeservice.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "Attendence")
public class AttendanceTime {
	
	@Id
	private String attendanceId;
	private String empId;
	private LocalDate date;
	private LocalTime clockIn;
	private LocalTime clockOut;
	private String totalHours;
}
