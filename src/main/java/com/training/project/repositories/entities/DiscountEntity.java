package com.training.project.repositories.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.training.project.dto.Bank;

@Entity
@Table(name="discount")
public class DiscountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer discountId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="bank_name")
	private Bank bankName;
	
	@Column(name="discount_percentage")
	private Integer discountPercentage;
	
	//getters and setters
	public Integer getDiscountId() {
		return discountId;
	}
	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}
	public Bank getBankName() {
		return bankName;
	}
	public void setBankName(Bank bankName) {
		this.bankName = bankName;
	}
	public Integer getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	//constructors
	public DiscountEntity( Bank bankName, Integer discountPercentage) {
		super();
		
		this.bankName = bankName;
		this.discountPercentage = discountPercentage;
	}
	public DiscountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	
	
}
