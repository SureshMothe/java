package com.example.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.entity.ServiceClass;

@Component
public class MyRunner implements CommandLineRunner {
	@Autowired
	private ServiceClass service;

	@Override
	public void run(String... args) throws Exception {
         		service.data();
	}

}
