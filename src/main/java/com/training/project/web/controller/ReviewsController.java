package com.training.project.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping(value="/{userEmail}/{movieName}/reviews")
	public ResponseEntity<ReviewsDto> addReviews(@RequestBody ReviewsDto reviewsDto,
			@PathVariable String userEmail, @PathVariable String movieName){
		ReviewsDto returnedReviewDto = reviewsService.saveReview(reviewsDto, userEmail, movieName);
		return new ResponseEntity<ReviewsDto>(returnedReviewDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/reviews/{id}")
	public ResponseEntity<ReviewsDto> getReviews(@PathVariable Integer id){
		ReviewsDto returnedReviewsDto = reviewsService.findReviewsById(id);
		return new ResponseEntity<ReviewsDto>(returnedReviewsDto, HttpStatus.OK);
	}

	
}
