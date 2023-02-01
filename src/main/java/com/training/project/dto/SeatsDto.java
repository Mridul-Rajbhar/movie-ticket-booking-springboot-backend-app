package com.training.project.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class SeatsDto {
	private Integer seatId;
	private char seatRow;
	private int seatNumber;
	@Enumerated(EnumType.STRING)
	private SeatsType seatType;
	
	@JsonBackReference(value="booking_seats")
	private BookingDto booking;

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
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
		return seatType;
	}

	public void setSeatType(SeatsType seatType) {
		this.seatType = seatType;
	}

	public BookingDto getBooking() {
		return booking;
	}

	public void setBooking(BookingDto booking) {
		this.booking = booking;
	}

	public SeatsDto(char seatRow, int seatNumber, SeatsType seatType) {
		super();
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
	}

	public SeatsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SeatsDto [seatId=" + seatId + ", seatRow=" + seatRow + ", seatNumber=" + seatNumber + ", seatsType="
				+ seatType +  "]";
	}
	
	
	
}
