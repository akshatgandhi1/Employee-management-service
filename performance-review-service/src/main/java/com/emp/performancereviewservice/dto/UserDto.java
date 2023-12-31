package com.emp.performancereviewservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

	private Integer empId;
	private String userName;
	private String userEmail;
	private String userNumber;
	private String userRole;
	private String designitation;
}
