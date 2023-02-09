package com.training.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonManagedReference;


public class BookingDto {
	private Integer bookingId;
	
	private MovieDto movie;
	
	@Enumerated(EnumType.STRING)
	private MovieLanguage language;
	
	private String movieFormat;
	private LocalDate bookingDate;
	private LocalTime bookingTime;
	
	@JsonManagedReference(value="booking_seats")
	private List<SeatsDto> seats;
	//setters and getters
	
	
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
	public List<SeatsDto> getSeats() {
		return seats;
	}
	public void setSeats(List<SeatsDto> seats) {
		this.seats = seats;
	}
	public BookingDto() {}
	public BookingDto(MovieDto movie, MovieLanguage language, String movieFormat,LocalDate bookingDate, LocalTime bookingTime) {
		this.movie = movie;
		this.language = language;
		this.movieFormat = movieFormat;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		
	}
	
	
	
	
	}
	
	
	

