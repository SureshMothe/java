package com.sathya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@GetMapping("/welcome")
	public ModelAndView mav() {
		System.out.println("mav() invoked");
		return new ModelAndView("welcome");
	}

}
