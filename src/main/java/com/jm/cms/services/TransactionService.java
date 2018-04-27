package com.jm.cms.services;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
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
import com.jm.cms.entities.CmsTransaction;
import com.jm.cms.exception.InsufficientBalanceException;
import com.jm.cms.exception.NotEnoughQuantityException;

@Service
public class TransactionService {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//@Transactional
	public List<CmsTransaction> getTransactions(){
		//Session session=sessionFactory.getCurrentSession();
		Session session=sessionFactory.openSession();

		Query query= session.createQuery("FROM CmsTransaction");	

		List tran =query.list();  

		return tran;
	}

	@Transactional
	public int createTransaction(CmsTransaction cmsTransaction) throws HibernateException,InsufficientBalanceException,NotEnoughQuantityException{
		int status = 1;

		Session session=sessionFactory.getCurrentSession();
		System.out.println("Obtained session<createTransaction>: "+session.toString());
		Query query1 =  session.createQuery("from CmsAccount a where a.accountNumber=:accountNumber");
		query1.setParameter("accountNumber", cmsTransaction.getAccountNumber());
		CmsAccount cmsAccount = (CmsAccount)query1.uniqueResult();
		if(cmsAccount.getAccountBalance().compareTo(cmsTransaction.getAmount())==-1)
			throw new InsufficientBalanceException();

		Query query2 =  session.createQuery("from CmsProduct p where p.productCode=:productCode");
		query2.setParameter("productCode", cmsTransaction.getProductCode());
		CmsProduct cmsProduct =  (CmsProduct)query2.uniqueResult();
		if(cmsProduct.getQuantity()<cmsTransaction.getQuantity())
			throw new NotEnoughQuantityException();


		session.persist(cmsTransaction);
		
		cmsAccount.setAccountBalance(cmsAccount.getAccountBalance().subtract(cmsTransaction.getAmount()));		
		session.persist(cmsAccount);
		
		cmsProduct.setQuantity(cmsProduct.getQuantity()-cmsTransaction.getQuantity());
		session.persist(cmsProduct);

		status = 0;


		return status;
	}

}
