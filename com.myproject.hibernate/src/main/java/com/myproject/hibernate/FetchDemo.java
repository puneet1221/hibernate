package com.myproject.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.hibernate.entities.Student;
import com.myproject.hibernate.service.StudentService;

public class FetchDemo {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		StudentService service = context.getBean(StudentService.class);
		Student s=service.getStudent(352L);
		System.out.println(s);
	

	}
}
