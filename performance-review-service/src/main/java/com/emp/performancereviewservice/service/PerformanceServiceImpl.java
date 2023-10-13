package com.emp.performancereviewservice.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.performancereviewservice.dto.PerformanceReqDto;
import com.emp.performancereviewservice.dto.PerformanceResDto;
import com.emp.performancereviewservice.entity.Performance;
import com.emp.performancereviewservice.exception.EmployeeIsNotpresentException;
import com.emp.performancereviewservice.exception.PerfomanceException;
import com.emp.performancereviewservice.externalservice.UserService;
import com.emp.performancereviewservice.repository.PerformanceRepository;

@Service
public class PerformanceServiceImpl implements PerformanceService{

	@Autowired
	private PerformanceRepository performanceRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserService service;
	
	@Override
	public PerformanceResDto addPerformance(PerformanceReqDto performanceReqDto) {
		boolean existEmpId = service.ExistEmpId(performanceReqDto.getEmpId());
		if (existEmpId) {
			Performance performance=modelMapper.map(performanceReqDto, Performance.class);
			List<Performance> findByMonth=performanceRepository.findByMonthAndEmpId(performance.getMonth(), performance.getEmpId());
			if (findByMonth.isEmpty()) {
				Performance savePerformance=performanceRepository.save(performance);
				return modelMapper.map(savePerformance, PerformanceResDto.class);
				
			}else {
				throw new PerfomanceException("already persent");
			}
		}else {
			throw new EmployeeIsNotpresentException("employee not present");
		}
		
	}

	@Override
	public List<PerformanceResDto> GetAllPerformance() {
		List<Performance> performance=performanceRepository.findAll();
		return performance.stream().map((per)->modelMapper.map(per, PerformanceResDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PerformanceResDto> getByEmpId(String empId) {
		List<Performance> findByEmpId = performanceRepository.findByEmpId(empId);
		return findByEmpId.stream().map((per)->modelMapper.map(per, PerformanceResDto.class)).collect(Collectors.toList());
	}

	@Override
	public PerformanceResDto updatePerformance(PerformanceReqDto performanceReqDto) {
		Performance performance = performanceRepository.findById(performanceReqDto.getPerId()).get();
		performance.setEmpId(performanceReqDto.getEmpId());
		performance.setReviewerName(performanceReqDto.getReviewerName());
		performance.setRating(performanceReqDto.getRating());
		performance.setFeedback(performanceReqDto.getFeedback());
		performance.setGoals(performanceReqDto.getGoals());
		Performance save = performanceRepository.save(performance);
		return modelMapper.map(save, PerformanceResDto.class);
	}

	@Override
	public void DeleteReview(String perId) {
		performanceRepository.deleteById(perId);
	}
}
