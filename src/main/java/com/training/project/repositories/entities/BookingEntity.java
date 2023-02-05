package com.training.project.repositories.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.training.project.dto.MovieLanguage;
import com.training.project.dto.SeatsDto;

@Entity
@Table(name="booking")
public class BookingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer bookingId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="movie_id", referencedColumnName = "id")
	private MovieEntity movie;
	
	@Column(name="movie_language")
	@Enumerated(EnumType.STRING)
	private MovieLanguage language;
	
	@Column(name="movie_format")
	private String movieFormat;
	
	@Column(name="booking_date")
	private LocalDate bookingDate;
	
	@Column(name="booking_time")
	private LocalTime bookingTime;
	
	@JsonManagedReference(value="booking_seats")
	@OneToMany(mappedBy = "booking")
	private List<SeatsEntity> seats;
	

	//setters and getters
	
	
	public List<SeatsEntity> getSeats() {
		return seats;
	}
	public void setSeats(List<SeatsEntity> seats) {
		this.seats = seats;
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public MovieEntity getMovie() {
		return movie;
	}
	public void setMovie(MovieEntity movie) {
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
	public BookingEntity(MovieEntity movie, MovieLanguage language, String movieFormat,
			LocalDate bookingDate, LocalTime bookingTime) {
		super();
		this.movie = movie;
		this.language = language;
		this.movieFormat = movieFormat;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
	}
	public BookingEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookingEntity [bookingId=" + bookingId + ", movie=" + movie + ", language=" + language
				+ ", movieFormat=" + movieFormat + ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime
				+ ", seats=" + seats + "]";
	}
	
	
	
	
}
