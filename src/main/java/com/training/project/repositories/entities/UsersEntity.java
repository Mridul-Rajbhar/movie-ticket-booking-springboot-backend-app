package com.training.project.repositories.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="users")
public class UsersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_address_id", referencedColumnName = "id")
	private ContactAddressEntity contactAddress;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference(value="user-order")
	private List<OrderEntity> orders;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference(value="user-review")
	private List<ReviewsEntity> reviews;
	
	
	//getter and setters

	public Integer getUserId() {
		return userId;
	}	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public ContactAddressEntity getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(ContactAddressEntity contactAddress) {
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
	
	public UsersEntity(ContactAddressEntity contactAddress, String firstName, String lastName, String gender,
			LocalDate dateOfBirth, String password) {
		super();
		this.contactAddress = contactAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
	}

	public UsersEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UsersEntity [userId=" + userId + ", contactAddress=" + contactAddress + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", password="
				+ password + ", orders=" + orders + "]";
	}
	
	
	
	
}
