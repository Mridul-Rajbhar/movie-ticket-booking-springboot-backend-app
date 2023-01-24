package com.training.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class Booking {
	private Integer bookingId;
	private Movie movie;
	private Users user;
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
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
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
	public Booking(Integer bookingId, Movie movie, Users user, MovieLanguage language, String movieFormat,
			LocalDate bookingDate, LocalTime bookingTime, List<String> seats) {
		super();
		this.bookingId = bookingId;
		this.movie = movie;
		this.user = user;
		this.language = language;
		this.movieFormat = movieFormat;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.seats = seats;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
