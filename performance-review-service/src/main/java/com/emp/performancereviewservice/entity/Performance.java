package com.emp.performancereviewservice.entity;

import java.time.LocalDate;
import java.time.Month;

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
@Document
public class Performance {

	@Id
	private String perId;
	private String empId;
	private String reviewerName;
	private Integer rating;
	private String feedback;
	private String goals;
	private Month month ;
}
