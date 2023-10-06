package com.emp.attendancetimeservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emp.attendancetimeservice.entity.AttendanceTime;

public interface AttendanceTimeRepository extends MongoRepository<AttendanceTime, String> {

}
