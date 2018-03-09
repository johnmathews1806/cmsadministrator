package com.jm.cms.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "PERMISSIONS")
public class Permission implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PERMISSION_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int permissionId;
	
	@ManyToMany(mappedBy="permissions")
	@Transient
	private Set<Role> roles = new HashSet<Role>();
			
	@Column(name = "PERMISSION_NAME")
	private String permissionName;
	
	@Column(name = "PERMISSION_DESCRIPTION")
	private String permissionDescription;
	
	@Column(name = "STATUS")
	private String status;

	
	
	public int getPermissionId() {
		return permissionId;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionDescription() {
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
		
}
