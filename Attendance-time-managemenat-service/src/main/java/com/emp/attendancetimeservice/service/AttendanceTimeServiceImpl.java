package com.emp.attendancetimeservice.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.attendancetimeservice.dto.AttendanceTimeResponceDto;
import com.emp.attendancetimeservice.entity.AttendanceTime;
import com.emp.attendancetimeservice.exception.AttendanceNotFoundException;
import com.emp.attendancetimeservice.repository.AttendanceTimeRepository;

@Service
public class AttendanceTimeServiceImpl implements AttendanceTimeService {

	@Autowired
	private AttendanceTimeRepository attendanceTimeRepository;

	@Autowired
	private ModelMapper modelMapper;

	Logger logger = LoggerFactory.getLogger(AttendanceTimeServiceImpl.class);

	@Override
	public AttendanceTimeResponceDto addClockInTime(String empId) {

		AttendanceTime attendanceTime = new AttendanceTime();
		Optional<AttendanceTime> findByDate = attendanceTimeRepository.findByDate(LocalDate.now());
		if(findByDate.isEmpty()) {
		attendanceTime.setEmpId(empId);
		attendanceTime.setClockIn(LocalTime.now());
		attendanceTime.setDate(LocalDate.now());
		attendanceTime.setClockOut(LocalTime.MIDNIGHT);
		attendanceTimeRepository.save(attendanceTime);
		return modelMapper.map(attendanceTime, AttendanceTimeResponceDto.class);
		}else {
			throw new RuntimeException("you have alerady clock-in for today");
		}

	}

	@Override
	public AttendanceTimeResponceDto addClockOutTime(String empId) {
		List<AttendanceTime> attendanceTime = attendanceTimeRepository.findByEmpIdAndClockOut(empId,
				LocalTime.MIDNIGHT);
		if (attendanceTime.isEmpty()) {
			throw new AttendanceNotFoundException("No open attendance record found for the employee");
		}
		AttendanceTime saveAttendance = attendanceTime.get(0);
		saveAttendance.setClockOut(LocalTime.now());

		Duration duration = Duration.between(saveAttendance.getClockIn(), saveAttendance.getClockOut());
		long hours = duration.toHours();
		long minutes = duration.toMinutesPart();

		String totalHours = String.format("%02d:%02d", hours, minutes);

		saveAttendance.setTotalHours(String.valueOf(totalHours));

		attendanceTimeRepository.save(saveAttendance);
		return modelMapper.map(saveAttendance, AttendanceTimeResponceDto.class);
	}

}
