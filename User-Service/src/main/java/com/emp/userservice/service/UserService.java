package com.emp.userservice.service;

import java.util.List;

import com.emp.userservice.dto.UserDto;
import com.emp.userservice.dto.UserReqDto;

public interface UserService {
	
	UserDto createUser(UserReqDto reqDto);
	List<UserDto> getAllUser();
	UserDto getUserbyId(String id);
	UserDto updateUser(UserDto userDto);
	void deleteUser(String id);
	UserDto updateuserByHR(UserDto dto);
	
}
