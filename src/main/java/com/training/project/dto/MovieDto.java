package com.training.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class MovieDto {
	
	private Integer movieId;
	
	@Enumerated(EnumType.STRING)
	private MovieGenre movieGenre;
	 
	private String movieName;
	private LocalTime duration;
	private String certificate;
	private LocalDate releaseDate;
	private String description;
	private String imageURL;
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	private List<ReviewsDto> reviews;
	
	private List<CastDto> cast;
	
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
	
	public List<ReviewsDto> getReviews() {
		return reviews;
	}
	public void setReviews(List<ReviewsDto> reviews) {
		this.reviews = reviews;
	}
	public List<CastDto> getCast() {
		return cast;
	}
	public void setCast(List<CastDto> cast) {
		this.cast = cast;
	}
	
	
	// constructor
	public MovieDto(MovieGenre movieGenre, String movieName, LocalTime duration, String certificate,
			LocalDate releaseDate, String description, String imageURL) {
		super();
		
		this.movieGenre = movieGenre;
		this.movieName = movieName;
		this.duration = duration;
		this.certificate = certificate;
		this.releaseDate = releaseDate;
		this.description = description;
		this.imageURL = imageURL;
	}
	public MovieDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
