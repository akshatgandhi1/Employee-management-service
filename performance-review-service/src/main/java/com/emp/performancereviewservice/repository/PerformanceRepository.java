package com.emp.performancereviewservice.repository;

import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emp.performancereviewservice.entity.Performance;

public interface PerformanceRepository extends MongoRepository<Performance, String>{

	List<Performance> findByEmpId(String empId);

	List<Performance> findByMonthAndEmpId(Month month, Integer empId);

}
