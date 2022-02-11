package com.example.springdemo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.EmployeeException;
import com.example.springdemo.model.Department;
import com.example.springdemo.model.Employee;
import com.example.springdemo.repository.DepartmentRepository;
import com.example.springdemo.repository.EmployeeRepository;
import com.example.springdemo.util.EmployeeUtil;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;
	
	private String employeeNotFoundErrMsg = "employee not found msg";
	
	private String deptNotFoundErrMsg = "department not found msg";
	
	@Override
	public List<Employee> getEmployees(Optional<String> sortField, Optional<String> sortDirection) {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee saveEmployee(Employee employee) throws EmployeeException {
		Department department = getDepartment(employee.getDepartment().getDepartmentId());
		employee.setDepartment(department);
		return employeeRepository.save(employee);
	}

	private Department getDepartment(long deptId) throws EmployeeException {
		try {
			Optional<Department> optionalDepartment = departmentRepository.findById(deptId);
			return optionalDepartment.get();
		} catch (NoSuchElementException ex) {
			throw new EmployeeException(EmployeeUtil.formatMsg(deptNotFoundErrMsg, deptId));
		}
	}
}
