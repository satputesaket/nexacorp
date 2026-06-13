package com.nexacorp.nexacorphrservice.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexacorp.nexacorphrservice.model.LeaveRecord;

public interface LeaveRecordRepository extends JpaRepository<LeaveRecord, Long> {

	Optional<LeaveRecord> findByUsernameAndLeaveDate(String username, LocalDate leaveDate);

}
