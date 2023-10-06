package com.emp.userservice.service;

import java.util.List;

import com.emp.userservice.dto.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userdto);
	List<UserDto> getAllUser();
	UserDto getUserbyId(String id);
	UserDto updateUser(UserDto userDto);
	void deleteUser(String id);
	
}
