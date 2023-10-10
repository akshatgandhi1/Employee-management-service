package com.emp.payrollservice.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayrollResDto {

	private String payrollId;
	private String empId;
	private Long salary;
	private Long bonus;
	private Long deduction;
	private Long netSalary;
	private LocalDate date;
}
