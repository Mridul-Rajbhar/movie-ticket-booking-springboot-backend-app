package com.training.project.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;

public class SeatsDto {
	
 private int seatId;
 
 @JsonBackReference(value="booking_seats")
 /*@Enumerated(EnumType.STRING)*/
 private BookingDto bookingId;
 
 private char seatRow;
 
 private int seatNumber;
 
 @Enumerated(EnumType.STRING)
 private SeatsType seatsType;
 
 
public int getSeatId() {
	return seatId;
}
public void setSeatId(int seatId) {
	this.seatId = seatId;
}
public BookingDto getBookingId() {
	return bookingId;
}
public void setBookingId(BookingDto bookingId) {
	this.bookingId = bookingId;
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
public SeatsType getSeatType() {
	return seatsType;
}
public void setSeatType(SeatsType seatsType) {
	this.seatsType = seatsType;
}
public SeatsDto(int seatId, BookingDto bookingId, char seatRow, int seatNumber, SeatsType seatsType) {
	super();
	this.seatId = seatId;
	this.bookingId = bookingId;
	this.seatRow = seatRow;
	this.seatNumber = seatNumber;
	this.seatsType = seatsType;
}
 

 
 
}
