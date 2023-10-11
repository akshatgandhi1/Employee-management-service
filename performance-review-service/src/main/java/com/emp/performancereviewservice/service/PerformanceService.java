package com.emp.performancereviewservice.service;

import java.util.List;

import com.emp.performancereviewservice.dto.PerformanceReqDto;
import com.emp.performancereviewservice.dto.PerformanceResDto;

public interface PerformanceService {

	PerformanceResDto addPerformance(PerformanceReqDto performanceReqDto);
	List<PerformanceResDto> GetAllPerformance();
	List<PerformanceResDto> getByEmpId(String empId);
	PerformanceResDto updatePerformance(PerformanceReqDto performanceReqDto);
	void DeleteReview(String perId);
}
