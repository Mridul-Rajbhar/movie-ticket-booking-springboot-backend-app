package com.training.project.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


public class UsersDto {
	
	private Integer userId;
	private ContactAddressDto contactAddress;
	private String firstName;
	private String lastName;
	private String gender;
	private LocalDate dateOfBirth;
	private String password;
	@JsonManagedReference(value="user-order")
	private List<OrderDto> orders;
	@JsonManagedReference(value="user-review")
	private List<ReviewsDto> reviews ;
	
	public Integer getUserId() {
		return userId;
	}
	
	//getter and setters
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public ContactAddressDto getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(ContactAddressDto contactAddress) {
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
	
	public List<ReviewsDto> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewsDto> reviews) {
		this.reviews = reviews;
	}

	//constructors
	
	public UsersDto( Integer userId, ContactAddressDto contactAddress, String firstName, String lastName, String gender,
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

	public UsersDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<OrderDto> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}

	
	
	
}
