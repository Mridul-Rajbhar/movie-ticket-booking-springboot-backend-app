package com.training.project.dto;

public class Discount {
	private Integer discountId;
	private String bankName;
	private Integer discountPercentage;
	
	//getters and setters
	public Integer getDiscountId() {
		return discountId;
	}
	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Integer getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	//constructors
	public Discount(Integer discountId, String bankName, Integer discountPercentage) {
		super();
		this.discountId = discountId;
		this.bankName = bankName;
		this.discountPercentage = discountPercentage;
	}
	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	
	
}
