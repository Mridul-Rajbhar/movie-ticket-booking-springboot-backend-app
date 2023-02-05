package com.training.project.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.dto.MovieDto;
import com.training.project.dto.MovieGenre;
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
	
	@CrossOrigin(origins="http://localhost:4200/")
	@PostMapping(value = "/movies", consumes = "application/json", produces = "application/json")
	 public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movie)
	{
	 // complete the code and return ResponseEnity object with status code 201
		 logger.info("POST : http://localhost:8080/api/v1/movies");
	    MovieDto returnedMovieDto =this.movieService.saveMovie(movie);
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
	public ResponseEntity<MovieDto> getMovieByName(@PathVariable("movieName")String movieName) {
		logger.info("get : http://localhost:8080/api/v1/movies/name/{movieName} ");
		this.movieService.findMovieByName(movieName);
		MovieDto movieDto= this.movieService.findMovieByName(movieName);
		if(movieDto == null) {
			logger.info("not found");
		}
		return ResponseEntity.ok(movieDto);
		
	    }
	
	@CrossOrigin(origins="http://localhost:4200/")
	@DeleteMapping(value="/movies/{movieName}")
	public Map<String,Boolean> deleteMovieByName(@PathVariable("movieName")String movieName) 
	{
		logger.info("DELETE : http://localhost:8080/api/v1/movies/{movieName} ");
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	        MovieDto movieDto = this.movieService.findMovieByName(movieName);
	        if (movieDto != null) {
	            this.movieService.deleteMovie(movieName);
	            map.put("deleted", Boolean.TRUE);
	        } else {
	           logger.info("not found");
	        }
	        return map;
	    }
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@RequestMapping(value = "/movies/{pageNumber}/{pageSize}", method = RequestMethod.GET)
	public Page<MovieDto> moviePagination(@PathVariable Integer pageNumber , @PathVariable Integer pageSize ){
		
		return movieService.getMoviePagination(pageNumber ,pageSize );
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@RequestMapping(value = "/movies/{movieGenreString}/{pageNumber}/{pageSize}", method = RequestMethod.GET)
	public Page<MovieDto> movieByGenrePagination(@PathVariable String movieGenreString, @PathVariable Integer pageNumber , @PathVariable Integer pageSize ){
		MovieGenre movieGenre = MovieGenre.valueOf(movieGenreString);
		return movieService.getMovieByGenrePagination(movieGenre, pageNumber ,pageSize );
	}
	
}
