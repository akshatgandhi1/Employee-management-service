package com.emp.leaveservice.dto;

import java.time.LocalDate;

import com.emp.leaveservice.Enum.LeaveStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequestDto {

	private String leaveReqId;
	private String empId;
	private String purpose;
	private LocalDate startDate;
	private LocalDate endDate;
	private LeaveStatus status;
	private String comments;
}
