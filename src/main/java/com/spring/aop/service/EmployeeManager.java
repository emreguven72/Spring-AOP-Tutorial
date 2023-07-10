package com.spring.aop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.aop.dataAccess.EmployeeRepository;
import com.spring.aop.entity.Employee;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final EmployeeBusinessRules employeeBusinessRules;
	
	@Override
	public List<Employee> getAll() {
		List<Employee> employees = this.employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee add(Employee employee) throws Exception {
		this.employeeBusinessRules.checkIfEmployeeNameValid(employee.getName());
		
		return this.employeeRepository.save(employee);
	}

}
