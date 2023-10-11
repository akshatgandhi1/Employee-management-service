package com.emp.performancereviewservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.performancereviewservice.dto.PerformanceReqDto;
import com.emp.performancereviewservice.dto.PerformanceResDto;
import com.emp.performancereviewservice.service.PerformanceService;

@RestController
@RequestMapping("/api/performance")
public class PerformanceController {

	@Autowired
	private PerformanceService performanceService;

	@PostMapping("/add")
	public PerformanceResDto addNewPerformance(@RequestBody PerformanceReqDto performanceReqDto) {
		return performanceService.addPerformance(performanceReqDto);
	}

	@GetMapping("/getall")
	public List<PerformanceResDto> getAll() {
		return performanceService.GetAllPerformance();
	}

	@GetMapping("/get/{empId}")
	public List<PerformanceResDto> getByEmpId(@PathVariable("empId") String empId) {
		return performanceService.getByEmpId(empId);
	}
	
	@PutMapping("/update/{perId}")
	public PerformanceResDto updateReview(@PathVariable("perId") String perId,@RequestBody PerformanceReqDto dto) {
		dto.setPerId(perId);
		return performanceService.updatePerformance(dto);
	}
	
	@DeleteMapping("/delete/{perId}")
	public void deleteReview(@PathVariable("perId") String perId) {
		performanceService.DeleteReview(perId);
	}
}
