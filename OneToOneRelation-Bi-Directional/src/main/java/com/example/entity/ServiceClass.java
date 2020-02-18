package com.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class ServiceClass {

	@Autowired
	private HibernateTemplate templete;
    
	@Transactional
	public void data() {
		/*InstructorDetails id = new InstructorDetails("www.youtube.com/krishna", "Sleeping,coding");
		Instructor i = new Instructor("KrishnaKumar", "Reddy", "krishna.reddy390@gmail.com");
        templete.save(id);
        InstructorDetails instructDetails = templete.get(InstructorDetails.class, 1);
        System.out.println(instructDetails);
        i.setInstructorDetails(instructDetails);
        templete.save(i);*/
        
        
        /*InstructorDetails d = templete.get(InstructorDetails.class, 1);
        System.out.println("InstructorDetails : "+d);
        templete.delete(d);
        System.out.println("InstructorDetails deleted...");*/
        
       /* Instructor d1 = templete.get(Instructor.class, 1);
        System.out.println("Instructor "+d1);
        templete.delete(d1);
        System.out.println("Instruction deleted...");*/
		
		InstructorDetails id = new InstructorDetails("www.youtube.com/krishna", "Sleeping,coding");
		Instructor i = new Instructor("KrishnaKumar", "Reddy", "krishna.reddy390@gmail.com");
		i.setInstructorDetails(id);
		templete.save(i);
		
		/*InstructorDetails id = templete.get(InstructorDetails.class, 3);
		id.getInstructor().setInstructorDetails(null);
		templete.delete(id);*/
		
		
	}
}
