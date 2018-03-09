package com.jm.cms.entities;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "CMS_PRODUCTS")
public class Product implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	
	
	@Column(name = "PRODUCT_CODE")
	private String productCode;
	
	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@Column(name = "CREATE_USER")
	private String createUser;
	
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	@Column(name = "UPDATE_USER")
	private String updateUser;
	
	@Column(name = "MANUFACTURER")
	private String manufacturer;
	
	@Column(name = "LAUNCH_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date launchDate;
	
	
	public int getProductId() {
		return productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}	
	
}
