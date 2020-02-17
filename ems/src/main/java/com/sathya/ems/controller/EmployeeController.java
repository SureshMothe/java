package com.sathya.ems.controller;

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

import com.sathya.ems.model.Employee;
import com.sathya.ems.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;

	@GetMapping("/home")
	public String homePage() {
		return "index";
	}

	@GetMapping("/employeepage")
	public String EmployeePage() {
		return "employeeregister";
	}

	@PostMapping("/register")
	public ModelAndView registerData(@RequestParam("empno") Integer empno, @RequestParam("empname") String empname,
			@RequestParam("age") Integer age, @RequestParam("sal") Double sal) {
		
		if (!repository.existsById(empno)) {
			Employee employee = new Employee();
			employee.setEmpno(empno);
			employee.setEmpname(empname);
			employee.setAge(age);
			employee.setSal(sal);
			try {

				repository.save(employee);
				return new ModelAndView("index", "msg", "Your data Register successfully..");
			} // try

			catch (Exception e) {
				
				return new ModelAndView("index", "msg", "Your data Registeration failed..");
			} // try

		} // if

		else {
			return new ModelAndView("index", "msg", "Data Already Exists..Please Change EmpId");
		}//else

	}

	@GetMapping("/employeelist")
	public String employeeList(ModelMap modelMap) {

		List<Employee> employee = repository.findAll();
		modelMap.addAttribute("emp", employee);
		return "employeelist";
	}

	@GetMapping("/editemployee")
	public String editEmployeeData(@RequestParam("empId") Integer id, ModelMap modelMap) {
		Optional<Employee> findById = repository.findById(id);
		Employee employee = findById.get();
		modelMap.addAttribute("emp", employee);
		return "editemployee";
	}

	@PostMapping("/updatedata")
	public String updateData(@ModelAttribute("emp") Employee employee, ModelMap modelMap) {
		repository.saveAndFlush(employee);
		List<Employee> employe1 = repository.findAll();
		modelMap.addAttribute("emp", employe1);
		return "employeelist";
	}

	@GetMapping("/deleteemployee")
	public String deleteEmployee(@RequestParam("empId") Integer id, ModelMap modelMap) {

		try {
			repository.deleteById(id);
			List<Employee> employe1 = repository.findAll();
			modelMap.addAttribute("emp", employe1);
			return "employeelist";
		} // try

		catch (Exception e) {
			e.printStackTrace();
			List<Employee> employe1 = repository.findAll();
			modelMap.addAttribute("emp", employe1);
			return "employeelist";
		}
	}

}
