package com.training.project.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.dto.MovieDto;
import com.training.project.services.MovieService;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
	
	private MovieService movieServices;
	private Logger  logger = LoggerFactory.getLogger(MovieController.class);
	
	 
	@Autowired
	public MovieController(MovieService movieServices) {
		this.movieServices=movieServices;
		logger.info("MovieController is logged in console");
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping("/movies")
	public ResponseEntity<List<MovieDto>> getMovie(){
		logger.info("GET Method : http://localhost:8080/api/v1/movies");
		List<MovieDto> list=this.movieServices.getAllMovies();
		return ResponseEntity.ok(list);
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@PostMapping(value = "/movies", consumes = "application/json", produces = "application/json")
	 public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movie)
	{
	 // complete the code and return ResponseEnity object with status code 201
		 logger.info("POST : http://localhost:8080/api/v1/movies");
	    MovieDto returnedMovieDto =this.movieServices.saveMovie(movie);
	    return new ResponseEntity<MovieDto>(returnedMovieDto, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@DeleteMapping(value="/movies/{movieName}")
	public Map<String,Boolean> deleteMovieByName(@PathVariable("movieName")String movieName) 
	{
		logger.info("DELETE : http://localhost:8080/api/v1/movies/{movieName} ");
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	        MovieDto movieDto = this.movieServices.findMovieByName(movieName);
	        if (movieDto != null) {
	            this.movieServices.deleteMovie(movieName);
	            map.put("deleted", Boolean.TRUE);
	        } else {
	           logger.info("not found");
	        }
	        return map;
	    }
	
	
	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping(value="/movies/{movieName}")
	public ResponseEntity<MovieDto> getMovieByName(@PathVariable("movieName")String movieName) {
	logger.info("get : http://localhost:8080/api/v1/movies/{movieName} ");
	this.movieServices.findMovieByName(movieName);
	MovieDto movieDto= this.movieServices.findMovieByName(movieName);
	if(movieDto == null) {
		logger.info("not found");
	}
	return ResponseEntity.ok(movieDto);
	
    }

}






