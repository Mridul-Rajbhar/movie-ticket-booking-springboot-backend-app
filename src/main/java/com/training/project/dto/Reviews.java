package com.training.project.dto;

public class Reviews {
	private Integer movieId;
	private Integer userId;
	private Integer stars;
	
	//setters and getters
	
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	
	//constructors
	
	public Reviews(Integer movieId, Integer userId) {
		super();
		this.movieId = movieId;
		this.userId = userId;
	}
	public Reviews() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
