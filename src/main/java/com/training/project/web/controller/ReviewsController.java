package com.training.project.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.dto.ReviewsDto;
import com.training.project.services.ReviewsService;

@RestController
@RequestMapping("api/v1")
public class ReviewsController {
	
	private Logger logger = LoggerFactory.getLogger(ReviewsController.class);
	@Autowired
	private ReviewsService reviewsService;
	
	public ReviewsController() {
		logger.info("Reviews Controller constructor created");
	}
	
	//postOrUpdate review by star
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="/reviews/star/{userId}/{movieName}")
	public ResponseEntity<ReviewsDto> addReviewByStar(@RequestBody Integer star,
			@PathVariable Integer userId, @PathVariable String movieName){
		ReviewsDto reviewsDto = this.reviewsService.saveReviewStar(star, userId, movieName);
		return new ResponseEntity<ReviewsDto>(reviewsDto, HttpStatus.OK);
	}
	
		//postOrUpdate review by comment
		@CrossOrigin(origins="http://localhost:4200")
		@PostMapping(value="/reviews/comment/{userId}/{movieName}")
		public ResponseEntity<ReviewsDto> addReviewByComment(@RequestBody String comment,
				@PathVariable Integer userId, @PathVariable String movieName){
			ReviewsDto reviewsDto = this.reviewsService.saveReviewComment(comment, userId, movieName);
			return new ResponseEntity<ReviewsDto>(reviewsDto, HttpStatus.OK);
		}
	
//	@CrossOrigin(origins="http://localhost:4200")
//	@PostMapping(value="/{userId}/{movieName}/reviews")
//	public ResponseEntity<ReviewsDto> addReviews(@RequestBody ReviewsDto reviewsDto,
//			@PathVariable Integer userId, @PathVariable String movieName){
//		ReviewsDto returnedReviewDto = reviewsService.saveReview(reviewsDto, userId, movieName);
//		return new ResponseEntity<ReviewsDto>(returnedReviewDto, HttpStatus.CREATED);
//	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/reviews/{id}")
	public ResponseEntity<ReviewsDto> getReviews(@PathVariable Integer id){
		ReviewsDto returnedReviewsDto = reviewsService.findReviewsById(id);
		return new ResponseEntity<ReviewsDto>(returnedReviewsDto, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/reviews/{userId}/{movieName}")
	public ResponseEntity<ReviewsDto> getReviewsByUserIdAndMovie(@PathVariable Integer userId,
			@PathVariable String movieName){
		ReviewsDto returnedReviewsDto = reviewsService.findReviewByUserAndMovie(userId, movieName);
		return new ResponseEntity<ReviewsDto>(returnedReviewsDto, HttpStatus.OK);
	}

	
}
