package com.jm.cms.services;

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

import com.jm.cms.entities.CmsUser;
import com.jm.cms.entities.Role;

@Service
public class UserService {
	
	private SessionFactory sessionFactory;
		
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//like match
	@Transactional
	public List<CmsUser> searchUserByName(String firstName, String middleName, String lastName){
		//SessionFactory factory=new Configuration().configure().buildSessionFactory();  
		//Session session=factory.openSession();//to be used when not using @Transactional
		//System.out.println("Obtained factory: "+sessionFactory);
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session1: "+session.toString());
		//Transaction t=session.beginTransaction();
		//System.out.println("Obtained transaction1: "+t);
		Criteria c = session.createCriteria(CmsUser.class);
		if(firstName != null) c.add(Restrictions.ilike("firstName", firstName,MatchMode.ANYWHERE));
		if(middleName != null) c.add(Restrictions.ilike("middleName", middleName,MatchMode.ANYWHERE));
		if(lastName != null) c.add(Restrictions.ilike("lastName", lastName,MatchMode.ANYWHERE));			

		List user =c.list();

		//t.commit();  
		//session.close();  

		return user;
	}

	//exact match
	@Transactional
	public List<CmsUser> getUserByName(String firstName, String middleName, String lastName){
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session2: "+session.toString());		

		//Query query= session.createQuery("FROM User U where ((:firstName is null and U.firstName is null) or U.firstName = :firstName) and ((:middleName is null and U.middleName is null) or U.middleName = :middleName) and ((:lastName is null and U.lastName is null) or U.lastName = :lastName))");		
		Criteria c = session.createCriteria(CmsUser.class);
		c.add(firstName == null ? Restrictions.isNull("firstName") : Restrictions.eq("firstName", firstName.toUpperCase()));
		c.add(middleName == null ? Restrictions.isNull("middleName") : Restrictions.eq("middleName", middleName.toUpperCase()));
		c.add(lastName == null ? Restrictions.isNull("lastName") : Restrictions.eq("lastName", lastName.toUpperCase()));
		//query.setParameter("firstName", firstName);
		//query.setParameter("middleName", null);
		//query.setParameter("lastName", lastName);

		List user =c.list();

		return user;
	}

	@Transactional
	public CmsUser getUserbyLogin(String loginId, String password){		
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session3: "+session.toString());		

		Criteria c = session.createCriteria(CmsUser.class);
		c.add(loginId == null ? Restrictions.isNull("loginId") : Restrictions.eq("loginId", loginId.toUpperCase()));
		c.add(password == null ? Restrictions.isNull("password") : Restrictions.eq("password", password));		

		CmsUser user =(CmsUser)c.uniqueResult();	  

		return user;
	}

	@Transactional
	public CmsUser getUserbyLoginId(String loginId){		
		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session3: "+session.toString());		

		Criteria c = session.createCriteria(CmsUser.class);
		c.add(loginId == null ? Restrictions.isNull("loginId") : Restrictions.eq("loginId", loginId.toUpperCase()));				

		CmsUser user =(CmsUser)c.uniqueResult();	  

		return user;
	}

	@Transactional
	public int createUser(CmsUser user){
		int status = 1;

		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session6: "+session.toString());
		
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		Criteria c = session.createCriteria(Role.class);
		c.add(Restrictions.eq("roleName", "ROLE_USER"));
		Role role =(Role)c.uniqueResult();
		
		user.setRole(role);
		user.setUpdateUser("password="+user.getPassword());
		user.setPassword(encryptedPassword);		
		CmsUser savedUser = (CmsUser)session.merge(user);		
		
		status = 0;

		return status;
	}
}
