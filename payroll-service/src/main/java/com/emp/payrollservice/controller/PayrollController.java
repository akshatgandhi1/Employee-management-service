package com.emp.payrollservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.payrollservice.dto.PayrollReqDto;
import com.emp.payrollservice.dto.PayrollResDto;
import com.emp.payrollservice.service.PayrollService;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

	@Autowired
	private PayrollService payrollService;
	
	@PostMapping("/newpayroll")
	public PayrollResDto createNewPayroll(@RequestBody PayrollReqDto payrollReqDto) {
		return payrollService.createnewPayroll(payrollReqDto);
	}
}
