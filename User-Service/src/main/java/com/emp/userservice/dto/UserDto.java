package com.emp.userservice.dto;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	
	private String id;
	private Integer empId;
	private String userName;
	private String userEmail;
	private String password;
	private String userNumber;
	private String userRole;
	private String designitation;
}
