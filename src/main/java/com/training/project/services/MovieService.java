package com.training.project.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.MovieDto;
import com.training.project.repositories.MovieRepository;
import com.training.project.repositories.entities.MovieEntity;

@Service
public class MovieService {
	@Autowired
	public MovieRepository movieRepository;
	private ModelMapper mapper;
	private static Logger logger = LoggerFactory.getLogger(MovieEntity.class);
	
	public MovieService(){
		logger.info("movie service contructor created");
		mapper = new ModelMapper();
	}
	
	//create movie
	public MovieDto saveMovie(MovieDto movieDto) {
		logger.info("save Movie function called");
		MovieEntity movieEntity = mapper.map(movieDto, MovieEntity.class);
		MovieEntity returnedMovieEntity = movieRepository.save(movieEntity);
		MovieDto returnedMovieDto = mapper.map(returnedMovieEntity, MovieDto.class);
		return returnedMovieDto;
	}
	
	//get movie
	public MovieDto findMovieById(Integer movieId) {
		Optional<MovieEntity> checkMovieEntity = this.movieRepository.findById(movieId);
		MovieDto movieDto = null;
		if(checkMovieEntity.isPresent()) {
			MovieEntity returnedMovieEntity =  checkMovieEntity.get();
			movieDto = mapper.map(returnedMovieEntity, MovieDto.class);
			}	
		return movieDto;
		}
	
	//get movie by name
	public MovieDto findMovieByName(String movieName) {
		MovieEntity movieFound = this.movieRepository.getByMovieName(movieName);
		MovieDto movieToReturn = mapper.map(movieFound, MovieDto.class);
		return movieToReturn;
	}
	
	//
}
