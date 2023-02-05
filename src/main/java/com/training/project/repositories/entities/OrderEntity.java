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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.training.project.dto.Bank;
import com.training.project.dto.CardType;

@Entity
@Table(name="order_details")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer orderId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id",referencedColumnName = "id")
	private BookingEntity booking;
	
	@ManyToOne
	@JoinColumn(name="discount_id")
	private DiscountEntity discount;
	
	 @Enumerated(EnumType.STRING)
	@Column(name="card_type")
	private CardType cardType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="bank_name")
	private Bank bank;
	
	@Column(name="amount")
	private Integer amount;
	
	@ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH})
	@JoinColumn(name="user_id")
	private UsersEntity user;
	//setters and getters 
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public BookingEntity getBooking() {
		return booking;
	}
	public void setBooking(BookingEntity booking) {
		this.booking = booking;
	}
	public DiscountEntity getDiscount() {
		return discount;
	}
	public void setDiscount(DiscountEntity discount) {
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
	
	public UsersEntity getUser() {
		return user;
	}
	public void setUser(UsersEntity user) {
		this.user = user;
	}
	
	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderEntity(BookingEntity booking, DiscountEntity discount, CardType cardType, Bank bank,
			Integer amount, UsersEntity user) {
		super();
		
		this.booking = booking;
		this.discount = discount;
		this.cardType = cardType;
		this.bank = bank;
		this.amount = amount;
		this.user = user;
	}
	
	
	 
}
