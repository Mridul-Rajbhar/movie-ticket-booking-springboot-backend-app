package com.training.project.repositories.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UsersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer userId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="contact_address_id",referencedColumnName = "id")
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
	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<OrderEntity> orders;
	
	public Integer getUserId() {
		return userId;
	}
	
	//getter and setters
	
	public void setUserId(Integer userId) {
		this.userId = userId;
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
		
	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	

	public UsersEntity(Integer userId, ContactAddressEntity contactAddress, String firstName, String lastName,
			String gender, LocalDate dateOfBirth, String password, List<OrderEntity> orders) {
		super();
		this.userId = userId;
		this.contactAddress = contactAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.orders = orders;
	}

	public UsersEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
