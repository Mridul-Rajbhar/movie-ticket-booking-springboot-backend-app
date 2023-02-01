package com.training.project.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class DiscountDto {
	private Integer discountId;
	
	@Enumerated(EnumType.STRING)
	private Bank bankName;
	
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
	public DiscountDto(Integer discountId, Bank bankName, Integer discountPercentage) {
		super();
		this.discountId = discountId;
		this.bankName = bankName;
		this.discountPercentage = discountPercentage;
	}
	public DiscountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	
	
}
