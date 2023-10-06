package com.emp.userservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {

	@Id
	private String id;
	private String userName;
	private String userEmail;
	private String password;
	private String userNumber;
	private String userRole;
	private String designitation;
}
