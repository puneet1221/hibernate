package com.myproject.hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Student {

	@Id

	@SequenceGenerator(name = "id_generator", sequenceName = "student_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_generator")
	long id;
	String name;
	String address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	public Student(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

}
