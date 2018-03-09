package com.jm.cms.entities;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "CMS_USERS")
public class CmsUser implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;	

	@ManyToOne
	//@JoinColumn(name="ROLE_ID", nullable=false)
	@JoinColumn(name="ROLE_ID")
	@JsonIgnore
	private Role role;

	
	@Column(name = "LOGIN_ID")
	private String loginId;

	@Column(name = "PASSWORD")
	private String password;

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
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


}
