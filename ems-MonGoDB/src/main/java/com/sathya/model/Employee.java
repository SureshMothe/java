package com.sathya.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "employee_tab")
@Data
public class Employee {
	@Id
	private String id;
	private String name;
	private Integer age;
	private Integer salary;
	
	
	

}
