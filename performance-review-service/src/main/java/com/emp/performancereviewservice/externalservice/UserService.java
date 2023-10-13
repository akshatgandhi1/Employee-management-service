package com.emp.performancereviewservice.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.emp.performancereviewservice.dto.UserDto;


@FeignClient(name="USER-SERVICE",path="/api/user")
public interface UserService {

	@GetMapping("/getbyempid/{empId}")
	public UserDto getByEmpId(@PathVariable("empId") Integer empId);
	
	@GetMapping("/existemp/{empId}")
	public boolean ExistEmpId(@PathVariable("empId") Integer empId);
}