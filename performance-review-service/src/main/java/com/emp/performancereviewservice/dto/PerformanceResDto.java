package com.emp.performancereviewservice.dto;

import java.time.LocalDate;
import java.time.Month;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceResDto {

	private String perId;
	private Integer empId;
	private String reviewerName;
	private Integer rating;
	private String feedback;
	private String goals;
	private Month month ;

}
