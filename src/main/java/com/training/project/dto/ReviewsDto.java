package com.training.project.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class ReviewsDto {
	private Integer reviewId;
	@JsonBackReference(value="movie-review")
	private MovieDto movie;
	@JsonBackReference(value="user-review")
	private UsersDto user;
	private String comment;
	private Integer stars;
	
	//setters and getters
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	
	public UsersDto getUser() {
		return user;
	}
	public void setUser(UsersDto user) {
		this.user = user;
	}
	
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	
	public MovieDto getMovie() {
		return movie;
	}
	public void setMovie(MovieDto movie) {
		this.movie = movie;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	//constructors
	public ReviewsDto(Integer stars, String comment) {
		super();
		this.stars = stars;
		this.comment = comment;
	}
	public ReviewsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReviewsDto [reviewId=" + reviewId + ", movie=" + movie + ", user=" + ", stars=" + stars + "]";
	}
	
	

	
	
}
