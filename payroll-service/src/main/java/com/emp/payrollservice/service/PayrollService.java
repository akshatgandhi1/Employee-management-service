package com.emp.payrollservice.service;

import java.util.List;

import com.emp.payrollservice.dto.PayrollReqDto;
import com.emp.payrollservice.dto.PayrollResDto;

public interface PayrollService {

	PayrollResDto createnewPayroll(PayrollReqDto payrollReqDto);
	
	List<PayrollResDto> getAllPayroll();
}
