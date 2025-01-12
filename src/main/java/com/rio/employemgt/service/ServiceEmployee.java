package com.rio.employemgt.service;

import java.util.List;

import com.rio.employemgt.model.Employee;

public interface ServiceEmployee {
	List<Employee> getEmployee();
	String createEmployee(Employee employee);
	String deleteEmployee(Long employeeId);
	String updateEmployee(Long employeeId,Employee employee);
}
