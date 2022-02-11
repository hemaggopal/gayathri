package com.example.springdemo.service;

import java.util.List;
import java.util.Optional;

import com.example.springdemo.EmployeeException;
import com.example.springdemo.model.Employee;

public interface IEmployeeService {
	public List<Employee> getEmployees(Optional<String> sortField, Optional<String> sortDirection);
	public Employee saveEmployee(Employee employee) throws EmployeeException;
}

