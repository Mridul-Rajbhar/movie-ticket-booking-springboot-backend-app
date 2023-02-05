package com.training.project.repositories.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import com.training.project.dto.MovieGenre;

@Entity
@Table(name="movie")
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer movieId;
	
    @Enumerated(EnumType.STRING)
	@Column(name="movie_genre")
	private MovieGenre movieGenre;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="duration")
	private LocalTime duration;
	
	@Column(name="certificate")
	private String certificate;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@Column(name="description")
	private String description;
	
	@Column(name="image_url")
	private String imageURL;
	
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	@OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
	private List<ReviewsEntity> reviews;
	
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "movie_cast_join_table",joinColumns = { @JoinColumn(name = "movie_id") },inverseJoinColumns = { @JoinColumn(name = "cast_id")})
	private List<CastEntity> cast;
	
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
	
	public List<ReviewsEntity> getReviews() {
		return reviews;
	}
	public void setReviews(List<ReviewsEntity> reviews) {
		this.reviews = reviews;
	}
	public List<CastEntity> getCast() {
		return cast;
	}
	public void setCast(List<CastEntity> cast) {
		this.cast = cast;
	}
	// constructor
	
	public MovieEntity() {}
	
	public MovieEntity(MovieGenre movieGenre, String movieName, LocalTime duration, String certificate,
			LocalDate releaseDate, String description, String imageURL) {
		
		this.movieGenre = movieGenre;
		this.movieName = movieName;
		this.duration = duration;
		this.certificate = certificate;
		this.releaseDate = releaseDate;
		this.description = description;
		this.imageURL = imageURL;
    	
	}
	
		
	}
	
	
	

