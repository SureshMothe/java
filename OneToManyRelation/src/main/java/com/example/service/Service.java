package com.example.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.course.Course;
import com.example.repository.TrainerRepository;
import com.example.trainer.Trainer;

@Component
public class Service {

	@Autowired
	private TrainerRepository repo;

	@Autowired
	private Trainer getData;

//	@Transactional
	public void add() {
		/*
		 * Trainer i1 = templete.get(Trainer.class, 1); Course c1 = new
		 * Course("the baseball"); Course c2 = new Course("football"); i1.add(c1);
		 * i1.add(c2);
		 * 
		 * templete.save(i1);
		 */

		/*
		 * Optional<Trainer> findById = repo.findById(1); Trainer getData =
		 * findById.get();
		 */

		Course c1 = new Course("the baseball");
		Course c2 = new Course("football");
		getData.addCourses(c1);
		getData.addCourses(c2);
		System.out.println("Data Saved...");
	}

}
