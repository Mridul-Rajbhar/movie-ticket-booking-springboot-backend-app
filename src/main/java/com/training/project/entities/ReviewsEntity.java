package com.training.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class ReviewsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH}  )
	@JoinColumn(name = "movie_id" , referencedColumnName = "id")
	private MovieEntity movie;
	
	@ManyToOne(cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH}  )
	@JoinColumn(name = "user_id" , referencedColumnName = "id")
	private UsersEntity user;
	
	@Column(name = "stars")
	private Integer stars;
	
	//setters and getters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public MovieEntity getMovie() {
		return movie;
	}
	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}
	public UsersEntity getUser() {
		return user;
	}
	public void setUser(UsersEntity user) {
		this.user = user;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	
	
	
	//constructors
	
	public ReviewsEntity(MovieEntity movie, UsersEntity user, Integer stars) {
		super();
		this.movie = movie;
		this.user = user;
		this.stars = stars;
	}
	
	public ReviewsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
