package com.training.project.dto;

public class ContactAddressDTO {
	
	private Integer contactAddressId;
	private String mobileNumber;
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
	public ContactAddressDTO(Integer contactAddressId, String mobileNumber, String email) {
		super();
		this.contactAddressId = contactAddressId;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}
	public ContactAddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
