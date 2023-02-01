package com.training.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class BookingDTO {
	private Integer bookingId;
	private MovieDTO movie;
	private MovieLanguage language;
	private String movieFormat;
	private LocalDate bookingDate;
	private LocalTime bookingTime;
	private List<String> seats;
	

	//setters and getters
	
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public MovieDTO getMovie() {
		return movie;
	}
	public void setMovie(MovieDTO movie) {
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
	public List<String> getSeats() {
		return seats;
	}
	public void setSeats(List<String> seats) {
		this.seats = seats;
	}
	//constructors
	public BookingDTO(Integer bookingId, MovieDTO movie, MovieLanguage language, String movieFormat,
			LocalDate bookingDate, LocalTime bookingTime, List<String> seats) {
		super();
		this.bookingId = bookingId;
		this.movie = movie;
		this.language = language;
		this.movieFormat = movieFormat;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.seats = seats;
	}
	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
