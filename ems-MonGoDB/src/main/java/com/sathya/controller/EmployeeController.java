package com.sathya.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.model.Employee;
import com.sathya.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@GetMapping("/home")
	public String homePage() {
		return "index";
	}

	@GetMapping("/registerpage")
	public String registerPage() {
		return "registerpage";
	}

	@PostMapping("/registartion")
	public ModelAndView saveData(@RequestParam("id") String pid, @RequestParam("name") String name,
			@RequestParam("age") Integer age, @RequestParam("sal") Integer sal) {
		System.out.println("register....");

		if (!repository.existsById(pid)) {
			Employee e = new Employee();
			e.setId(pid);
			e.setName(name);
			e.setAge(age);
			e.setSalary(sal);

			try {
				repository.save(e);
				return new ModelAndView("index", "emp", "Your Data Insertion successfully completed..");
			} // try
			catch (Exception e1) {
				return new ModelAndView("index", "emp", "Data Insertion Failed..");
			}

		} // if

		else {
			return new ModelAndView("index", "emp", "Employye Id already register,Please try with different id");
		}
	}
	
	@GetMapping("/Employeelist")
	public String list(ModelMap modelMap) {
		List<Employee> findAll = repository.findAll();
		modelMap.addAttribute("emp", findAll);
		return "Employeelist";
	}
	
	@GetMapping("/editData")
	public String editdata(@RequestParam("empId") String id,ModelMap modelMap) {
		Optional<Employee> employee = repository.findById(id);
		modelMap.addAttribute("emp", employee);
		return "editData";
	}
	
	@PostMapping("/editedData")
	public String list1(@ModelAttribute Employee employee ,ModelMap modelMap) {
		repository.save(employee);
		List<Employee> findAll = repository.findAll();
		modelMap.addAttribute("emp", findAll);
		return "Employeelist";
	}
	
	@GetMapping("/deleteData")
	public String deleteData(@RequestParam("empId") String id,ModelMap modelMap) {
		repository.deleteById(id);
		List<Employee> findAll = repository.findAll();
		modelMap.addAttribute("emp", findAll);
		return "Employeelist";
	}
	
	
}
