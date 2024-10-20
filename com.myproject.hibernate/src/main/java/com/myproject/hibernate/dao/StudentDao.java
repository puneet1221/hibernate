package com.myproject.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.hibernate.entities.Student;
import com.myproject.hibernate.service.StudentService;

@Repository
public class StudentDao implements StudentService {

	@Autowired
	private SessionFactory factory;

	// Add a new student
	@Override
	@Transactional
	public Student addStudent(Student student) {
		Session session = factory.getCurrentSession();
		session.persist(student);
		return student; // Return the saved student (with generated ID)
	}

	// Get a student by ID
	@Override
	@Transactional(readOnly = true)
	public Student getStudent(Long id) {
		Session session = factory.getCurrentSession();
		return session.get(Student.class, id);
	}

	// Update an existing student
	@Override
	@Transactional
	public void updateStudent(Student student) {
		Session session = factory.getCurrentSession();
		session.merge(student);
	}

	// Delete a student by ID
	@Transactional
	@Override
	public void deleteStudent(Long id) {
		Session session = factory.getCurrentSession();
		Student student = session.get(Student.class, id);
		if (student != null) {
			session.delete(student);
		}
	}
}
