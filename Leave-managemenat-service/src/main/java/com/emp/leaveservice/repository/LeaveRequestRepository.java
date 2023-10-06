package com.emp.leaveservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emp.leaveservice.entity.LeaveRequest;

public interface LeaveRequestRepository extends MongoRepository<LeaveRequest, String> {

}
