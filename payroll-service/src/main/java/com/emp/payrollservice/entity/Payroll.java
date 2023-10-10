package com.emp.payrollservice.entity;

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
public class Payroll {

	@Id
	private String payrollId;
	private String empId;
	private Long salary;
	private Long bonus;
	private Long deduction;
	private Long netSalary;
	private LocalDate date;
}
