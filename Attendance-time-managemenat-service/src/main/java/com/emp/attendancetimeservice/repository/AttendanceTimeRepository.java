package com.emp.attendancetimeservice.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emp.attendancetimeservice.entity.AttendanceTime;

public interface AttendanceTimeRepository extends MongoRepository<AttendanceTime, String> {

	List<AttendanceTime> findByEmpIdAndClockOut(String empId, LocalTime midnight);

	Optional<AttendanceTime> findByDate(LocalDate now);


}
