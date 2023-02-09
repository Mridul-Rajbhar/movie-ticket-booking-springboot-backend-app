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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.training.project.dto.SeatsType;

@Entity
@Table(name="seats")
public class SeatsEntity {
	
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="id")
 private Integer seatsId;
 
 @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
 @JoinColumn(name="booking_id",referencedColumnName="id")
 @JsonBackReference(value="booking_seats")
 private BookingEntity booking;
 
 @Column(name="seat_row")
 private char seatRow;
 
 
 @Column(name="seat_number")
 private int seatNumber;
 
 @Enumerated(EnumType.STRING)
 @Column(name="seat_type")
 private SeatsType seatsType;
 
 
public Integer getSeatsId() {
	return seatsId;
}
public void setSeatsId(Integer seatsId) {
	this.seatsId = seatsId;
}
public BookingEntity getBooking() {
	return booking;
}
public void setBookingId(BookingEntity booking) {
	this.booking = booking;
}
public char getSeatRow() {
	return seatRow;
}
public void setSeatRow(char seatRow) {
	this.seatRow = seatRow;
}
public int getSeatNumber() {
	return seatNumber;
}
public void setSeatNumber(int seatNumber) {
	this.seatNumber = seatNumber;
}
public SeatsType getSeatsType() {
	return seatsType;
}
public void setSeatsType(SeatsType seatsType) {
	this.seatsType = seatsType;
}
public void setBooking(BookingEntity booking) {
	this.booking = booking;
}
public SeatsEntity(/*BookingEntity booking,*/ char seatRow, int seatNumber, SeatsType seatsType) {
	super();
	
	//this.booking = booking;
	this.seatRow = seatRow;
	this.seatNumber = seatNumber;
	this.seatsType = seatsType;
}

 
}
