package com.training.project.web.controller;


import java.util.List;


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

import com.training.project.dto.MovieDTO;
import com.training.project.dto.MovieGenre;
import com.training.project.services.MovieServices;



@RestController
@RequestMapping("/api/v1")
public class MovieController {

	@Autowired
	private MovieServices movieService;
	
	public MovieController(MovieServices movieServices) {
		this.movieService = movieServices;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping(value = "/movies")
	public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movie){
		MovieDTO returnedmovieDTO = this.movieService.saveMovie(movie);
		
		return new ResponseEntity<MovieDTO>(returnedmovieDTO , HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping(value = "/movies")
	public ResponseEntity<List<MovieDTO>> getAllMovies(){
		List<MovieDTO> list = this.movieService.getMovie();
		
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping(value = "/movies/{movieName}")
	public String deleteMovieByName(@PathVariable ("movieName") String movieName){
		
		 return movieService.deleteMovie(movieName)+ " Movie deleted ";

	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping(value = "/movies/{movieName}")
	public ResponseEntity<MovieDTO> getMovieByName(@PathVariable("movieName") String movieName){
		return new ResponseEntity<MovieDTO>(this.movieService.findMovieByName(movieName) , HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@RequestMapping(value = "/movies/{pageNumber}/{pageSize}", method = RequestMethod.GET)
	public Page<MovieDTO> moviePagination(@PathVariable Integer pageNumber , @PathVariable Integer pageSize ){
		
		return movieService.getMoviePagination(pageNumber ,pageSize );
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@RequestMapping(value = "/movies/{movieGenreString}/{pageNumber}/{pageSize}", method = RequestMethod.GET)
	public Page<MovieDTO> movieByGenrePagination(@PathVariable String movieGenreString, @PathVariable Integer pageNumber , @PathVariable Integer pageSize ){
		MovieGenre movieGenre = MovieGenre.valueOf(movieGenreString);
		return movieService.getMovieByGenrePagination(movieGenre, pageNumber ,pageSize );
	}
}
