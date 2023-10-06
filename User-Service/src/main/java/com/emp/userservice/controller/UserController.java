package com.emp.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.userservice.dto.UserDto;
import com.emp.userservice.entity.User;
import com.emp.userservice.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public UserDto createnewUser(@RequestBody UserDto userdto) {
		return userService.createUser(userdto);
	}
	
	@GetMapping("/getAll")
	public List<UserDto> getAllUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("/getAll/{id}")
	public UserDto getById(@PathVariable("id") String id){
		return userService.getUserbyId(id);
	}
	
	@PutMapping("/update/{id}")
	public UserDto updateUser(@PathVariable("id") String id,UserDto userDto) {
		userDto.setId(id);
		return userService.updateUser(userDto);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteuser(@PathVariable("id") String id) {
		userService.deleteUser(id);
	}
}
