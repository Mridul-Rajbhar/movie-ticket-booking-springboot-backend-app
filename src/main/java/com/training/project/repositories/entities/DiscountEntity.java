package com.training.project.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.training.project.dto.Bank;

@Entity
@Table(name="discount")
public class DiscountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer discountId;
	
	@Column(name="bank_name")
	@Enumerated(EnumType.STRING)
	private Bank bankName;
	
	@Column(name="discount_percentage")
	private double discountPercentage;
	
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
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	//constructors
	public DiscountEntity(Bank bankName, double d) {
		super();
		this.bankName = bankName;
		this.discountPercentage = d;
	}
	public DiscountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DiscountEntity [discountId=" + discountId + ", bankName=" + bankName + ", discountPercentage="
				+ discountPercentage + "]";
	}
	
	
	
	 
	
	
}
