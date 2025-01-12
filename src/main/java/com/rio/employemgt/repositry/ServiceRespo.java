package com.rio.employemgt.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rio.employemgt.model.Employee;

public interface ServiceRespo extends JpaRepository<Employee,Long>{

}
