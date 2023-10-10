package com.emp.payrollservice.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.payrollservice.dto.PayrollReqDto;
import com.emp.payrollservice.dto.PayrollResDto;
import com.emp.payrollservice.entity.Payroll;
import com.emp.payrollservice.exception.AlreadyEnterpayrollException;
import com.emp.payrollservice.exception.MonthPresentException;
import com.emp.payrollservice.repository.PayrollRepository;

@Service
public class PayrollServiceImpl implements PayrollService{
	
	@Autowired
	private PayrollRepository payrollRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public PayrollResDto createnewPayroll(PayrollReqDto payrollReqDto) {
		
		
		Payroll payroll=mapper.map(payrollReqDto, Payroll.class);
		String empId=payroll.getEmpId();
		LocalDate date=LocalDate.of(2023, 10, 12);
		Optional<Payroll> findByDate= payrollRepository.findByDateAndEmpId(date,empId);
		
		
		
		if(findByDate.isPresent()) {	
			throw new AlreadyEnterpayrollException("Payroll of particular employee already enterd");
		}
		
		else if(findByDate.get().getDate().getMonthValue() == date.getMonthValue() 
				&& findByDate.get().getDate().getYear() == date.getYear()){
			throw new MonthPresentException("Payroll of particular employee already enterd for this month");
		}
		
		else {
			payroll.setDate(date);
			payroll.setNetSalary(payroll.getSalary()+payroll.getBonus()-payroll.getDeduction());	
			Payroll savePayroll=payrollRepository.save(payroll);
			return mapper.map(savePayroll, PayrollResDto.class);
		}
	}

	@Override
	public List<PayrollResDto> getAllPayroll() {
		// TODO Auto-generated method stub
		return null;
	}

}
