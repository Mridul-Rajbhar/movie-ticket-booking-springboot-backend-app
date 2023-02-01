package com.training.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MovieDTO {
	
	private Integer movieId;
	private MovieGenre movieGenre;
	private String movieName;
	private LocalTime duration;
	private String certificate;
	private LocalDate releaseDate;
	private String description;
	
	private List<ReviewsDTO> reviews;
	private List<CastDTO> cast;
	
	private String imageURL; 
	
	//setters and getters
	
	public Integer getMovieId() {
		return movieId;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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
	
	public List<ReviewsDTO> getReviews() {
		return reviews;
	}
	public void setReviews(List<ReviewsDTO> reviews) {
		this.reviews = reviews;
	}
	public List<CastDTO> getCast() {
		return cast;
	}
	public void setCast(List<CastDTO> cast) {
		this.cast = cast;
	}
	
	
	// constructor
	public MovieDTO( MovieGenre movieGenre, String movieName, LocalTime duration, String certificate,
			LocalDate releaseDate, String description, List<CastDTO> cast, String imageURL) {
		super();
		
		this.movieGenre = movieGenre;
		this.movieName = movieName;
		this.duration = duration;
		this.certificate = certificate;
		this.releaseDate = releaseDate;
		this.description = description;
		this.cast = cast;
		this.imageURL = imageURL;
	}
	public MovieDTO() {
		
	}

	
	
	
	
}
