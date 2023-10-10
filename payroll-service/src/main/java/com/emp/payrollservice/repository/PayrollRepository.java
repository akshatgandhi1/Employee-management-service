package com.emp.payrollservice.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.emp.payrollservice.entity.Payroll;

@Repository
public interface PayrollRepository extends MongoRepository<Payroll, String> {
	
	Optional<Payroll> findByDateAndEmpId(LocalDate date, String empId);
	
	
    Optional<Payroll> findByEmpIdAndDateYearAndDateMonthValue(String empId, int year, int month);

}
