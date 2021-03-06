package com.jm.cms.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jm.cms.entities.CmsAccount;
import com.jm.cms.entities.CmsProduct;

@Service
public class ProductService {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	//@Transactional
	public List<CmsProduct> getProducts(){
		//Session session=sessionFactory.getCurrentSession();
		Session session=sessionFactory.openSession();

		Query query= session.createQuery("FROM CmsProduct");	
		
		List prod =query.list();  
		
		return prod;
	}
	
	//@Transactional
	public CmsProduct getProduct(int productId){
		Session session=sessionFactory.getCurrentSession();

		Query query= session.createQuery("FROM CmsProduct p where p.productId=:productId");
		query.setParameter("productId", productId);
		
		CmsProduct prod =(CmsProduct)query.uniqueResult();	  
		
		return prod;
	}
	
	@Transactional
	public List<CmsAccount> searchCustomerByName(String firstName, String middleName, String lastName){
		
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session1: "+session.toString());
		Criteria c = session.createCriteria(CmsAccount.class);
		if(firstName != null) c.add(Restrictions.ilike("firstName", firstName,MatchMode.ANYWHERE));
		if(middleName != null) c.add(Restrictions.ilike("middleName", middleName,MatchMode.ANYWHERE));
		if(lastName != null) c.add(Restrictions.ilike("lastName", lastName,MatchMode.ANYWHERE));			

		List<CmsAccount> accounts =c.list();

		return accounts;
	}

}
