package com.spring.aop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.aop.entity.Employee;
import com.spring.aop.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@GetMapping()
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.employeeService.getAll());
	}
	
	
	@PostMapping()
	public ResponseEntity<?> add(@RequestBody Employee employee) throws Exception {
		return ResponseEntity.ok(this.employeeService.add(employee));
	}
	
}
