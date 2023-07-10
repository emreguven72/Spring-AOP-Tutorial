package com.spring.aop.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeBusinessRules {
	
	public void checkIfEmployeeNameValid(String name) throws Exception {
		if(name.length() < 3) {
			throw new Exception("Name must be at least 3 characters");
		}
		return;
	}
	
}
