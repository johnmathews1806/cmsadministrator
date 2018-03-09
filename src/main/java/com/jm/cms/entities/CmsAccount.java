package com.jm.cms.entities;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CMS_ACCOUNTS")
public class CmsAccount implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ACCOUNT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountId;
	
	@Column(name = "ACCOUNT_NUMBER")	
	private int accountNumber;	

	@Column(name = "ACCOUNT_BALANCE")
	private BigDecimal accountBalance;
	
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;	

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "CREATE_USER")
	private String createuser;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@Column(name = "UPDATE_USER")
	private String updateUser;

	
}
