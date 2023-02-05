package com.training.project.dto;

public class ReviewsDto {
	private Integer reviewId; 
	private MovieDto movie;
	private UsersDto user;
	private Integer stars;
		
	public ReviewsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewsDto(MovieDto movie, UsersDto user, Integer stars) {
		super();
		this.movie = movie;
		this.user = user;
		this.stars = stars;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public MovieDto getMovie() {
		return movie;
	}

	public void setMovie(MovieDto movie) {
		this.movie = movie;
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

}