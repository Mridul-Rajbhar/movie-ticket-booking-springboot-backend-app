package com.training.project.dto;

import java.time.LocalDate;

public class Users {
	
	private Integer userId;
	private ContactAddress contactAddress;
	private String firstName;
	private String lastName;
	private String gender;
	private LocalDate dateOfBirth;
	private String password;
	public Integer getUserId() {
		return userId;
	}
	
	//getter and setters
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public ContactAddress getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(ContactAddress contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//constructors
	
	public Users(Integer userId, ContactAddress contactAddress, String firstName, String lastName, String gender,
			LocalDate dateOfBirth, String password) {
		super();
		this.userId = userId;
		this.contactAddress = contactAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
