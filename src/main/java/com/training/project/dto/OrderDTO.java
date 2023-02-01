package com.training.project.dto;

public class OrderDTO {
	private Integer orderId;
	private BookingDTO booking;
	private DiscountDTO discount;
	private CardType cardType;
	private Bank bank;
	private Integer amount;
	private UsersDTO user;
	
	//setters and getters 
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public BookingDTO getBooking() {
		return booking;
	}
	public void setBooking(BookingDTO booking) {
		this.booking = booking;
	}
	public DiscountDTO getDiscount() {
		return discount;
	}
	public void setDiscount(DiscountDTO discount) {
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
	
	public UsersDTO getUser() {
		return user;
	}
	public void setUser(UsersDTO user) {
		this.user = user;
	}
	
	//constructors 
	
	
	public OrderDTO(Integer orderId, BookingDTO booking, DiscountDTO discount, CardType cardType, Bank bank, Integer amount, UsersDTO user) {
		super();
		this.orderId = orderId;
		this.booking = booking;
		this.discount = discount;
		this.cardType = cardType;
		this.bank = bank;
		this.amount = amount;
		this.user = user;
	}
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 
}
