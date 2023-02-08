package com.training.project.repositories.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.training.project.dto.BookingDto;
import com.training.project.dto.SeatsType;

@Entity
@Table(name="seats")
public class SeatsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer seatId;
	
	@Column(name="seat_row")
	private char seatRow;
	
	@Column(name="seat_number")
	private int seatNumber;
	
	@Column(name="seat_type")
	@Enumerated(EnumType.STRING)
	private SeatsType seatType;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonBackReference(value="booking_seats")
	private BookingEntity booking;

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

	public BookingEntity getBooking() {
		return booking;
	}

	public void setBooking(BookingEntity booking) {
		this.booking = booking;
	}
	public SeatsEntity(char seatRow, int seatNumber, SeatsType seatType) {
		super();
		this.seatRow = seatRow;
		this.seatNumber = seatNumber;
		this.seatType = seatType;
	}

	public SeatsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SeatsEntity [seatId=" + seatId + ", seatRow=" + seatRow + ", seatNumber=" + seatNumber + ", seatsType="
				+ seatType + "]";
	}
	
	 
}
