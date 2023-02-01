package com.training.project.dto;




public class ReviewsDTO {
	
	private Integer id;
	private MovieDTO movie;
	private UsersDTO user;
	private Integer stars;
	
	//setters and getters
	public MovieDTO getMovie() {
		return movie;
	}
	public void setMovie(MovieDTO movieId) {
		this.movie = movieId;
	}
	public UsersDTO getUser() {
		return user;
	}
	public void setUser(UsersDTO user) {
		this.user = user;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	//constructors
	
	
	public ReviewsDTO(MovieDTO movie, UsersDTO user , Integer stars) {
		super();
		this.movie = movie;
		this.user = user;
		this.stars = stars;
	}
	
	public ReviewsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
