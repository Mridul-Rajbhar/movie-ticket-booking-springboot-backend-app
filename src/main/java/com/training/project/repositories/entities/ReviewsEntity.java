package com.training.project.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="reviews")
public class ReviewsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer reviewId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="movie_id", referencedColumnName = "id")
	@JsonBackReference(value="movie-review")
	private MovieEntity movie;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName = "id")
	@JsonBackReference(value="user-review")
	private UsersEntity user;
//	
	@Column(name="stars")
	private Integer stars;
	
	//setters and getters
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
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
		this.user= user;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	//constructors
	
	public ReviewsEntity(Integer stars, String comment) {
		super();
		this.stars = stars;
		this.comment = comment;
	}
	public ReviewsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "ReviewsEntity [reviewId=" + reviewId + ", stars=" + stars + "comment" + comment + "]";
	}
	
	

	
	
}
