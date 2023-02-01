package com.training.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class MovieDto {
	
	private Integer movieId;
	private MovieGenre movieGenre;
	private String movieName;
	private LocalTime duration;
	private String certificate;
	private LocalDate releaseDate;
	private String description;
	private String imageURL;
	@JsonManagedReference(value="movie-review")
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
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	// constructor
	public MovieDto( Integer movieId,MovieGenre movieGenre, String movieName, LocalTime duration, String certificate,
			LocalDate releaseDate, String description, String imageURL) {
		super();
		this.movieId = movieId;
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
	@Override
	public String toString() {
		return "MovieDto [movieId=" + movieId + ", movieGenre=" + movieGenre + ", movieName=" + movieName
				+ ", duration=" + duration + ", certificate=" + certificate + ", releaseDate=" + releaseDate
				+ ", description=" + description + ", reviews=" + reviews + ", cast=" + cast + "]";
	}

	
	
	
	
	
}
