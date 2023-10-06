package com.emp.userservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.userservice.dto.UserDto;
import com.emp.userservice.entity.User;
import com.emp.userservice.exception.UserAlreadyPresentException;
import com.emp.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UserDto createUser(UserDto userdto) {
		User user=mapper.map(userdto, User.class);
		Optional<User> user1=userRepository.findByUserEmail(user.getUserEmail());
		if (user1.isPresent()) {
			throw new UserAlreadyPresentException("Email already present");
		}
		else {
			User saveuser=userRepository.save(user);
			UserDto dto=mapper.map(saveuser, UserDto.class);
			return dto;
		}
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> user=userRepository.findAll();
		return user.stream().map((users)->mapper.map(users, UserDto.class)).collect(Collectors.toList()) ;
	}

	@Override
	public UserDto getUserbyId(String id) {
		Optional<User> user=userRepository.findById(id);
		UserDto dto=mapper.map(user, UserDto.class);
		return dto;
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		User user=userRepository.findById(userDto.getId()).get();
		user.setUserName(userDto.getUserName());
		user.setUserEmail(userDto.getUserEmail());
		user.setPassword(userDto.getPassword());
		user.setUserNumber(userDto.getUserNumber());
		user.setUserRole(userDto.getUserRole());
		user.setDesignitation(userDto.getDesignitation());

		User updateUser= userRepository.save(user);
		return mapper.map(updateUser, UserDto.class);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}
}
