package com.training.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


public class BookingDto {
	private Integer bookingId;
	private MovieDto movie;
	private MovieLanguage language;
	private String movieFormat;
	private LocalDate bookingDate;
	private LocalTime bookingTime;
	
	@JsonManagedReference(value="booking_seats")
	private List<SeatsDto> seats;
	

	//setters and getters
	
	
	public List<SeatsDto> getSeats() {
		return seats;
	}
	public void setSeats(List<SeatsDto> seats) {
		this.seats = seats;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public MovieDto getMovie() {
		return movie;
	}
	public void setMovie(MovieDto movie) {
		this.movie = movie;
	}
	
	public MovieLanguage getLanguage() {
		return language;
	}
	public void setLanguage(MovieLanguage language) {
		this.language = language;
	}
	public String getMovieFormat() {
		return movieFormat;
	}
	public void setMovieFormat(String movieFormat) {
		this.movieFormat = movieFormat;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalTime getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(LocalTime bookingTime) {
		this.bookingTime = bookingTime;
	}
	

	//constructors
	public BookingDto(MovieDto movie, MovieLanguage language, String movieFormat,
			LocalDate bookingDate, LocalTime bookingTime) {
		super();
		this.movie = movie;
		this.language = language;
		this.movieFormat = movieFormat;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
	}

	public BookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookingDto [bookingId=" + bookingId + ", movie=" + movie + ", language=" + language + ", movieFormat="
				+ movieFormat + ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime + ", seats=" + this.seats
				+ "]";
	}
	
	
	
	
	
	
	
}
