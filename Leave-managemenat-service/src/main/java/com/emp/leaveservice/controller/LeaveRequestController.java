package com.emp.leaveservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.leaveservice.dto.LeaveRequestDto;
import com.emp.leaveservice.service.LeaveRequestService;

@RestController
@RequestMapping("/api/leaverequest")
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService leaveRequestService;
	
	@PostMapping("/newrequest")
	public LeaveRequestDto newleaveRequest(@RequestBody LeaveRequestDto requestDto) {
		return leaveRequestService.requestleave(requestDto);
	}
	
	@PutMapping("/leavestatus/{leaveReqId}")
	public LeaveRequestDto updateleaveStatus(@PathVariable("leaveReqId") String leaveReqid,@RequestParam String status) {
		return leaveRequestService.updateLeaveStatus(leaveReqid, status);
	}
	
	@GetMapping("/getallleaverequest")
	public List<LeaveRequestDto> getAllLeaveRequest(){
		return leaveRequestService.AllRequest();
	}
}
