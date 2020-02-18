package com.example.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.service.Service;

@Component
public class MyRunner implements CommandLineRunner {
   
    
	@Autowired
	private ApplicationContext context;
	
	@Override
	public void run(String... args) throws Exception {
		Service s = context.getBean("service",Service.class);
		s.add();
		
	}

}
