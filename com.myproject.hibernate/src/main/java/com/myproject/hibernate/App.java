package com.myproject.hibernate;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.hibernate.dao.AddressDao;
import com.myproject.hibernate.entities.Address;

public class App {
	@Transactional
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//		StudentService service = context.getBean(StudentService.class);
//
//		// Create a student
//		Student student = new Student("Puneet", "Mumbai");
//		System.out.println(service.addStudent(student));
//
//		// Close the context
//
//		for (int i = 0; i < 100; i++) {
//			System.out.println(service.addStudent(new Student("name" + i, "address" + i)));
//		}

		AddressDao session2 = context.getBean(AddressDao.class);
		File f = new File("C:\\Users\\admin\\Desktop\\images\\Capture.PNG");
		System.out.println(f);
		FileInputStream stream = new FileInputStream(f);
		byte[] image = new byte[stream.available()];
		stream.read(image);
		;
		Address adr = new Address();
		adr.setCity("mumbai");
		adr.setStreet("farid nagar");
		adr.setOpen(false);
		adr.setX(3.14);
		adr.setImage(image);

		session2.addAddress(adr);
		
		
		System.out.println(session2.getAddressDetails(8L));
		
	
		
		stream.close();

	}
}
