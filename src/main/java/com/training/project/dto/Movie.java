package com.training.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Movie {
	
	private Integer movieId;
	private MovieGenre movieGenre;
	private String movieName;
	private LocalTime duration;
	private String certificate;
	private LocalDate releaseDate;
	private String description;
	
	private List<Reviews> reviews;
	private List<Cast> cast;
	
	//setters and getters
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public MovieGenre getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(MovieGenre movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalTime getDuration() {
		return duration;
	}
	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Reviews> getReviews() {
		return reviews;
	}
	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}
	public List<Cast> getCast() {
		return cast;
	}
	public void setCast(List<Cast> cast) {
		this.cast = cast;
	}
	
	
	// constructor
	public Movie(Integer movieId, MovieGenre movieGenre, String movieName, LocalTime duration, String certificate,
			LocalDate releaseDate, String description) {
		super();
		this.movieId = movieId;
		this.movieGenre = movieGenre;
		this.movieName = movieName;
		this.duration = duration;
		this.certificate = certificate;
		this.releaseDate = releaseDate;
		this.description = description;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
