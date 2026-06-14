package com.nexacorp.nexacorphrservice.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexacorp.nexacorphrservice.model.LeaveRecord;
import com.nexacorp.nexacorphrservice.service.HRService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hr")
@RequiredArgsConstructor
public class HRController {

	private final HRService hrService;

	@PostMapping("/leave")
	public LeaveRecord applyLeave(@RequestParam String username,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return hrService.applyLeave(username, date);
	}

	@GetMapping("/leave/{username}")
	public boolean isOnLeave(@PathVariable String username,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return hrService.isOnLeave(username, date);
	}
	
	
	@GetMapping("/replacement/{username}")
	public String findReplacement(@PathVariable String username,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return hrService.findReplacement(username, date);
	}
}
