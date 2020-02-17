package com.sathya.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sathya.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	
}
