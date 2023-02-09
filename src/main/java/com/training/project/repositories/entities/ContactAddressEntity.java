package com.training.project.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_address")
public class ContactAddressEntity {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer contactAddressId;
	
	@Column(name = "mobile_no")
	private String mobileNumber;
	
	@Column(name = "email")
	private String email;
	
	
	//getter and setter
	
	public Integer getContactAddressId() {
		return contactAddressId;
	}
	public void setContactAddressId(Integer contactAddressId) {
		this.contactAddressId = contactAddressId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//constructor
	public ContactAddressEntity(Integer contactAddressId, String mobileNumber, String email) {
		super();
		this.contactAddressId = contactAddressId;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	public ContactAddressEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
