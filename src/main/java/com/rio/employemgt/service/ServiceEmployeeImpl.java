package com.rio.employemgt.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.rio.employemgt.model.Employee;
import com.rio.employemgt.repositry.ServiceRespo;




@Service
public class ServiceEmployeeImpl implements ServiceEmployee {
	
	@Autowired
	private ServiceRespo serviceRespo;
	
	@Override
	public List<Employee> getEmployee(){
		return serviceRespo.findAll();
	}
	
	@Override
	public String createEmployee(Employee employee) {
		serviceRespo.save(employee);
		return "Employee created succesfully";
	}
	
	@Override
	public String deleteEmployee(Long employeeId) {
		Optional<Employee> employees =  serviceRespo.findById(employeeId);
		Employee employee = employees.stream()
							.filter(c-> c.getId().equals(employeeId)).findFirst()
							.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not found"));
		serviceRespo.delete(employee);
		return "Employee deleted sucessfully "+employeeId;
	}
	
	@Override
	public String updateEmployee(Long employeeId,Employee employee) {
		Optional<Employee> employees =  serviceRespo.findById(employeeId);
		Employee employee2 = employees.stream()
							.filter(c->c.getId().equals(employeeId)).findFirst()
							.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found"));
		employee2.setEmail(employee.getEmail());
		employee2.setPhoneNo(employee.getPhoneNo());
		serviceRespo.save(employee2);
		return "Employed updated sucessfully for Id : "+employeeId;
	}
}
