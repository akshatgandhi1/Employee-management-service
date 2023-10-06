package com.emp.leaveservice.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.emp.leaveservice.Enum.LeaveStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class LeaveRequest {

	@Id
	private String leaveReqId;
	private String empId;
	private String purpose;
	private LocalDate startDate;
	private LocalDate endDate;
	private LeaveStatus status;
	private String comments;
}
