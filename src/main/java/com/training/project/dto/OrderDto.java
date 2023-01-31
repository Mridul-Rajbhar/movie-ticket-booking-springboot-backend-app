package com.training.project.dto;

public class OrderDto {
	private Integer orderId;
	private BookingDto booking;
	private DiscountDto discount;
	private CardType cardType;
	private Bank bank;
	private Integer amount;
	private UsersDto user;
	//setters and getters 
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public BookingDto getBooking() {
		return booking;
	}
	public void setBooking(BookingDto booking) {
		this.booking = booking;
	}
	public DiscountDto getDiscount() {
		return discount;
	}
	public void setDiscount(DiscountDto discount) {
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
	
	public UsersDto getUser() {
		return user;
	}
	public void setUser(UsersDto user) {
		this.user = user;
	}
	public OrderDto(BookingDto booking, DiscountDto discount,
			CardType cardType, Bank bank, Integer amount, UsersDto user) {
		super();
		this.booking = booking;
		this.discount = discount;
		this.cardType = cardType;
		this.bank = bank;
		this.amount = amount;
		this.user = user;
	}
	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 
}
