package com.spring.aop.service;

import java.util.List;

import com.spring.aop.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAll();
	
	Employee add(Employee employee) throws Exception;
	
}
