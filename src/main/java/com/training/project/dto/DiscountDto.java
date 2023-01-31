package com.training.project.dto;

public class DiscountDto {
	private Integer discountId;
	private Bank bankName;
	private Float discountPercentage;
	
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
	public Float getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	//constructors
	public DiscountDto(Bank bankName, Float discountPercentage) {
		super();
		this.bankName = bankName;
		this.discountPercentage = discountPercentage;
	}
	public DiscountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	
	
}
