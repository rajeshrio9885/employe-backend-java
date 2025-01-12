package com.rio.employemgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rio.employemgt.model.Employee;
import com.rio.employemgt.service.ServiceEmployee;

@CrossOrigin("*")
@RestController
public class EmployeeController {
	
	@Autowired
	private ServiceEmployee serviceEmployee;
	
	@GetMapping("/api/getEmployee")
	public List<Employee> getEmployee() {
		return serviceEmployee.getEmployee();
	}
	
	@PostMapping("/api/createEmployee")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		String status = serviceEmployee.createEmployee(employee);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/api/deleteEmployee/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
		try {
			String status = serviceEmployee.deleteEmployee(employeeId);
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getReason(),e.getStatusCode());
		}
		
	}
	
	@PutMapping("/api/updateEmployee/{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee){
		try {
			String status = serviceEmployee.updateEmployee(employeeId,employee);
			return new ResponseEntity<>(status,HttpStatus.OK);
		} catch (ResponseStatusException e) {
			return new ResponseEntity<>(e.getReason(),e.getStatusCode());
		}
		
	}
}
