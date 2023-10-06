package com.emp.leaveservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.leaveservice.Enum.LeaveStatus;
import com.emp.leaveservice.dto.LeaveRequestDto;
import com.emp.leaveservice.entity.LeaveRequest;
import com.emp.leaveservice.repository.LeaveRequestRepository;

@Service
public class LeaveRequestServiceimpl implements LeaveRequestService {

	@Autowired
	private LeaveRequestRepository requestRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LeaveRequestDto requestleave(LeaveRequestDto dto) {
		LeaveRequest leaveRequest = modelMapper.map(dto, LeaveRequest.class);
		leaveRequest.setStatus(LeaveStatus.PENDING);
		LeaveRequest saveRequest = requestRepository.save(leaveRequest);

		LeaveRequestDto requestDto = modelMapper.map(saveRequest, LeaveRequestDto.class);
		return requestDto;
	}

	@Override
	public LeaveRequestDto updateLeaveStatus(String leaveReqId, String status) {
		LeaveRequest leaveRequest = requestRepository.findById(leaveReqId).get();
		if (leaveRequest != null) {
			if (status.equals(LeaveStatus.APPROVED.name())) {
				leaveRequest.setStatus(LeaveStatus.APPROVED);
			} else if (status.equals(LeaveStatus.REJECTED.name())) {
				leaveRequest.setStatus(LeaveStatus.REJECTED);
			}

			LeaveRequest saveRequest = requestRepository.save(leaveRequest);
			LeaveRequestDto requestDto = modelMapper.map(saveRequest, LeaveRequestDto.class);
			return requestDto;

		}
		return null;
	}

	@Override
	public List<LeaveRequestDto> AllRequest() {
		List<LeaveRequest> leaveRequests = requestRepository.findAll();

		return leaveRequests.stream().map((requests) -> modelMapper.map(requests, LeaveRequestDto.class))
				.collect(Collectors.toList());
	}

}
