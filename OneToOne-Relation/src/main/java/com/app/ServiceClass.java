package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ServiceClass {

	@Autowired
	private HibernateTemplate templete;

	public void data() {
		InstructorDetails id = new InstructorDetails(101, "www.youtube.com/krishna", "Sleeping,coding");
		Instructor i = new Instructor(201, "KrishnaKumar", "Reddy", "krishna.reddy390@gmail.com");

		saveData(id, i);

	}

	@Transactional
	public void saveData(InstructorDetails id, Instructor i) {
	     
		templete.save(id);
	 
	}

}
