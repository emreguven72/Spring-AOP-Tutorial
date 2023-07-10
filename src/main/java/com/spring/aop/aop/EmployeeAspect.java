package com.spring.aop.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.spring.aop.entity.Employee;

@Aspect
@Component
public class EmployeeAspect {

	@Before(value = "execution(* com.spring.aop.controller.EmployeeController.*(..))")
	public void beforeAdviceForController(JoinPoint joinPoint) {
		System.out.println("Request to controller layer " + joinPoint.getSignature() + " started at " + new Date());
		System.out.println("----------------------------");
	}
	
	@After(value = "execution(* com.spring.aop.controller.EmployeeController.*(..))")
	public void afterAdviceForController(JoinPoint joinPoint) {
		System.out.println("Request to controller layer " + joinPoint.getSignature() + " ended at " + new Date());
		System.out.println("----------------------------");
	}
	
	@Before(value = "execution(* com.spring.aop.service.EmployeeService.*(..))")
	public void beforeAdviceForService(JoinPoint joinPoint) {
		System.out.println("Request to service layer " + joinPoint.getSignature() + " started at " + new Date());
		System.out.println("----------------------------");
	}
	
	@After(value = "execution(* com.spring.aop.service.EmployeeService.*(..))")
	public void afterAdviceForService(JoinPoint joinPoint) {
		System.out.println("Request to service layer " + joinPoint.getSignature() + " ended at " + new Date());
		System.out.println("----------------------------");
	}
	
	@Before(value = "execution(* com.spring.aop.dataAccess.EmployeeRepository.*(..))")
	public void beforeAdviceForRepository(JoinPoint joinPoint) {
		System.out.println("Request to repository layer " + joinPoint.getSignature() + " started at " + new Date());
		System.out.println("----------------------------");
	}
	
	@After(value = "execution(* com.spring.aop.dataAccess.EmployeeRepository.*(..))")
	public void afterAdviceForRepository(JoinPoint joinPoint) {
		System.out.println("Request to repository layer " + joinPoint.getSignature() + " ended at " + new Date());
		System.out.println("----------------------------");
	}
	
	@AfterReturning(value = "execution(* com.spring.aop.service.EmployeeService.add(..))", returning = "employee")
	public void afterReturningAdviceForEmployeeAddService(JoinPoint joinPoint, Employee employee) {
		System.out.println("Business logic to save an employee ran succesfully and employee is saved with id " + employee.getId());
		System.out.println("----------------------------");
	}
	
	@AfterThrowing(value = "execution(* com.spring.aop.service.EmployeeService.add(..))", throwing = "exception")
	public void afterThrowingAdviceForEmployeeAddService(JoinPoint joinPoint, Exception exception) {
		System.out.println("Business logic to save an employee threw an exception " + exception.getMessage());
		System.out.println("----------------------------");
	}
	
	@Around(value = "execution(* com.spring.aop.service.EmployeeService.add(..))")
	public Employee aroundAdviceForEmployeeAddService(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Inside Around Advice in Aspect : Business logic to save employee started at " + new Date());
		System.out.println("----------------------------");
		
		try {
			return (Employee)joinPoint.proceed(); //It calls the real add method
		} catch (Exception e) {
			System.out.println("Inside Around Advice in Aspect : Business logic to save employee failed terribly " + e.getMessage());
			System.out.println("----------------------------");
		}
		
		System.out.println("Inside Around Advice in Aspect : Business logic to save employee ended at" + new Date());
		System.out.println("----------------------------");
		return null;
	}
	
	
}
