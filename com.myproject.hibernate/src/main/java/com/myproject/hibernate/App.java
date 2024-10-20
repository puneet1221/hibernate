package com.myproject.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myproject.hibernate.entities.Student;
import com.myproject.hibernate.service.StudentService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		StudentService service = context.getBean(StudentService.class);

		// Create a student
		Student student = new Student("Puneet", "Mumbai");
		System.out.println(service.addStudent(student));

		// Close the context

		for (int i = 0; i < 100; i++) {
			System.out.println(service.addStudent(new Student("name" + i, "address" + i)));
		}

	}
}
