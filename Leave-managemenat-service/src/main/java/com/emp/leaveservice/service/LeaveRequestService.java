package com.emp.leaveservice.service;

import java.util.List;

import com.emp.leaveservice.dto.LeaveRequestDto;

public interface LeaveRequestService {

	LeaveRequestDto requestleave(LeaveRequestDto dto);
	LeaveRequestDto updateLeaveStatus(String leaveReqId,String status);
	List<LeaveRequestDto> AllRequest();
}
