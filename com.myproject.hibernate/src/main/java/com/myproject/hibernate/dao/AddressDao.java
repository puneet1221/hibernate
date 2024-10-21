package com.myproject.hibernate.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.hibernate.entities.Address;

@Repository
public class AddressDao {

	@Autowired
	private SessionFactory factory;

	@Transactional
	public void addAddress(Address ad) {
		Session session = factory.getCurrentSession();
		session.persist(ad);

	}

	@Transactional
	public Address getAddress(Long id) {
		Session session = factory.getCurrentSession();
		return session.get(Address.class, id);
	}


	@Transactional
	public Address loadAddress(Long id) {
		Session session = factory.getCurrentSession();
		Address ad=session.load(Address.class, id);
		System.out.println("proxy object successfully built");
		return ad;
	}
	@Transactional
	public String getAddressDetails(Long id) {
        Address address = loadAddress(id); // Call to loadAddress() within a transaction
        System.out.println("iske baad query fire hogi");
        return address.getStreet(); // Access properties here
    }

}
