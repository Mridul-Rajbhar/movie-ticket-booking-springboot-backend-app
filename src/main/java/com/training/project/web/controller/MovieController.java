package com.training.project.web.controller;

import java.util.List;

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

import com.training.project.dto.MovieDto;
import com.training.project.dto.OrderDto;
import com.training.project.dto.ReviewsDto;
import com.training.project.repositories.entities.ReviewsEntity;
import com.training.project.services.MovieService;
import com.training.project.services.OrderService;

@RequestMapping("api/v1")
@RestController
public class MovieController {

	
	private Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private MovieService movieService;
	
	public MovieController() {
		logger.info("Movie Controller constructor created");
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/movies/reviews/{movieName}")
	public ResponseEntity<List<ReviewsDto>> getAllReviews(@PathVariable String movieName){
		List<ReviewsDto> allReviews = this.movieService.getAllReviewsForMovie(movieName);
		return new ResponseEntity<List<ReviewsDto>>(allReviews, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/movies")
	public ResponseEntity<List<MovieDto>> getAllMovies(){
		List<MovieDto> allMovies = this.movieService.getAllMovies();
		return new ResponseEntity<List<MovieDto>>(allMovies, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="/movies")
	public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto){
		MovieDto returnedMovieDto = movieService.saveMovie(movieDto);
		return new ResponseEntity<MovieDto>(returnedMovieDto, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/movies/number/{id}")
	public ResponseEntity<MovieDto> getMovie(@PathVariable Integer id){
		MovieDto returnedMovieDto = movieService.findMovieById(id);
		return new ResponseEntity<MovieDto>(returnedMovieDto, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/movies/name/{movieName}")
	public ResponseEntity<MovieDto> getMovieByName(@PathVariable String movieName){
		return new ResponseEntity<MovieDto>(movieService.findMovieByName(movieName), HttpStatus.OK);
	}
}
