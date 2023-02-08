package com.training.project.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.MovieDto;
import com.training.project.dto.ReviewsDto;
import com.training.project.dto.UsersDto;
import com.training.project.repositories.ContactAddressRepository;
import com.training.project.repositories.MovieRepository;
import com.training.project.repositories.ReviewsRepository;
import com.training.project.repositories.UsersRepository;
import com.training.project.repositories.entities.ContactAddressEntity;
import com.training.project.repositories.entities.MovieEntity;
import com.training.project.repositories.entities.ReviewsEntity;
import com.training.project.repositories.entities.UsersEntity;

@Service
public class ReviewsService {

	@Autowired
	private ReviewsRepository reviewsRepository;
	
	@Autowired
	private ContactAddressRepository contactAddressRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	private ModelMapper mapper;
	private static Logger logger = LoggerFactory.getLogger(ReviewsEntity.class);
	
	public ReviewsService() {
		// TODO Auto-generated constructor stub
		logger.info("review service constructor created");
		mapper = new ModelMapper();
	}
	
	
	//post review with star
	public ReviewsDto saveReviewStar(Integer star, Integer userId, String movieName) {
		MovieEntity movieToBook = this.movieRepository.getByMovieName(movieName);
		UsersEntity usersEntity = this.userRepository.findById(userId).get();
		
		ReviewsEntity reviewsEntity = this.reviewsRepository.findReviewByUserAndMovie(usersEntity, movieToBook);
		ReviewsEntity returnedReviewEntity = null;
		if(reviewsEntity!=null) {
			reviewsEntity.setStars(star);
			returnedReviewEntity = this.reviewsRepository.save(reviewsEntity);
		}
		else {
			reviewsEntity = new ReviewsEntity();
			reviewsEntity.setMovie(movieToBook);
			reviewsEntity.setUser(usersEntity);
			reviewsEntity.setStars(star);
			reviewsEntity.setComment("");
			returnedReviewEntity = this.reviewsRepository.save(reviewsEntity);
		}
		
		ReviewsDto reviewsDto = mapper.map(returnedReviewEntity, ReviewsDto.class);
		return reviewsDto;
		
	}
	
	
	//save review with comment
	public ReviewsDto saveReviewComment(String comment, Integer userId, String movieName) {
		MovieEntity movieToBook = this.movieRepository.getByMovieName(movieName);
		UsersEntity usersEntity = this.userRepository.findById(userId).get();
		
		ReviewsEntity reviewsEntity = this.reviewsRepository.findReviewByUserAndMovie(usersEntity, movieToBook);
		ReviewsEntity returnedReviewEntity = null;
		if(reviewsEntity!=null) {
			reviewsEntity.setComment(comment);
			returnedReviewEntity = this.reviewsRepository.save(reviewsEntity);
		}
		else {
			reviewsEntity = new ReviewsEntity();
			reviewsEntity.setMovie(movieToBook);
			reviewsEntity.setUser(usersEntity);
			reviewsEntity.setStars(null);
			reviewsEntity.setComment(comment);
			returnedReviewEntity = this.reviewsRepository.save(reviewsEntity);
		}
		
		ReviewsDto reviewsDto = mapper.map(returnedReviewEntity, ReviewsDto.class);
		return reviewsDto;
		
	}
	
	
	
	//create reviews
	public ReviewsDto saveReview(ReviewsDto reviewsDto, Integer userId, String movieName) {
		MovieEntity movieToBook = this.movieRepository.getByMovieName(movieName);
		UsersEntity usersEntity = this.userRepository.findById(userId).get();
		
		ReviewsEntity reviewsEntity = mapper.map(reviewsDto, ReviewsEntity.class);
				
		reviewsEntity.setMovie(movieToBook);
		reviewsEntity.setUser(usersEntity);
		
//		System.out.println(reviewsEntity);
//		movieToBook.add(reviewsEntity);
//		usersEntity.addReviews(reviewsEntity);
		
		System.out.println(movieToBook);
		System.out.println(reviewsEntity);
		ReviewsEntity returnedReviewsEntity = this.reviewsRepository.save(reviewsEntity);
		ReviewsDto returnReviewsDto = null;
		returnReviewsDto = mapper.map(returnedReviewsEntity, ReviewsDto.class);
//		System.out.println(e);
		
//		return reviewsDto;
		return returnReviewsDto;
	}
	
		//get reviews
		public ReviewsDto findReviewsById(Integer reviewId) {
			Optional<ReviewsEntity> checkReviewsEntity = this.reviewsRepository.findById(reviewId);
			ReviewsDto reviewDto = null;
			if(checkReviewsEntity.isPresent()) {
				ReviewsEntity returnedReviewEntity =  checkReviewsEntity.get();
				reviewDto = mapper.map(returnedReviewEntity, ReviewsDto.class);
			}	
			System.out.println(reviewDto);
			return reviewDto;
		}
	
		//get review by user and movie
		public ReviewsDto findReviewByUserAndMovie(Integer userId, String movieName) {
			System.out.println(movieName);
			MovieEntity movieToBook = this.movieRepository.getByMovieName(movieName);
			UsersEntity usersEntity = this.userRepository.findById(userId).get();
			System.out.println(movieToBook);
			System.out.println(usersEntity);
			ReviewsEntity reviewsEntity = this.reviewsRepository.findReviewByUserAndMovie(usersEntity, movieToBook);
			ReviewsDto reviewsDto = null;
			if(reviewsEntity != null) 
				reviewsDto  = mapper.map(reviewsEntity, ReviewsDto.class);
			return reviewsDto;
			
		}
}
