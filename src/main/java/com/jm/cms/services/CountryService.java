package com.jm.cms.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jm.cms.entities.Country;


//@Service
public class CountryService {
	
	private SessionFactory sessionFactory;
	
	//@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	//@Transactional
	public List<String> getCountries(){
		System.out.println("in getCountries service");
		//Session session=sessionFactory.getCurrentSession();
		Session session=sessionFactory.openSession();

		Query query= session.createQuery("Select countryName FROM Country");	
		
		List countries =query.list();
		
		session.close();
		
		return countries;
	}
}
