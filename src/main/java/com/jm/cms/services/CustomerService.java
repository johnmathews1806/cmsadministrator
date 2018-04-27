package com.jm.cms.services;

import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jm.cms.entities.CmsAccount;
import com.jm.cms.entities.CmsUser;
import com.jm.cms.entities.Role;

@Service
public class CustomerService {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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
		

	@Transactional
	public int createCustomer(CmsAccount account){
		int status = 1;

		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session<createCustomer>: "+session.toString());
		
		//Account Number logic		
		Calendar today = Calendar.getInstance();	//Current date
		
		int year = today.get(Calendar.YEAR);			
		int month =today.get(Calendar.MONTH);			
		int date =  today.get(Calendar.DATE);
		long sec =  today.getTimeInMillis();

		//String formattedDate=String.valueOf(year)+String.format("%02d",  month+1)+String.format("%02d",  date);
		String formattedDate=String.format("%02d",  date);
		long accountNumber = Long.parseLong(formattedDate+Long.toString(sec));
		
		account.setAccountNumber(accountNumber);
		
		System.out.println("balance : "+account.getAccountBalance());
		CmsAccount cmsAccount = (CmsAccount)session.merge(account);		
		
		status = 0;

		return status;
	}
}
