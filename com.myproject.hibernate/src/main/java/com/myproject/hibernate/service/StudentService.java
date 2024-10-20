package com.myproject.hibernate.service;

import org.springframework.stereotype.Service;

import com.myproject.hibernate.entities.Student;

@Service
public interface StudentService {

	public Student addStudent(Student student);
	public Student getStudent(Long id) ;
	public void updateStudent(Student student);
	public void deleteStudent(Long id) ;
}
