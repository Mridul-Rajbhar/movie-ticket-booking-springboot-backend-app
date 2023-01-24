package com.training.project.dto;

public class Order {
	private Integer orderId;
	private Booking booking;
	private Discount discount;
	private CardType cardType;
	private Bank bank;
	private Integer amount;
	
	//setters and getters 
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	public CardType getCardType() {
		return cardType;
	}
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	//constructors 
	
	public Order(Integer orderId, Booking booking, Discount discount, CardType cardType, Bank bank, Integer amount) {
		super();
		this.orderId = orderId;
		this.booking = booking;
		this.discount = discount;
		this.cardType = cardType;
		this.bank = bank;
		this.amount = amount;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 
}
