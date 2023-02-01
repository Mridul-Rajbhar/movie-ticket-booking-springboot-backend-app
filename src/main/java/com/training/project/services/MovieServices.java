package com.training.project.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.MovieDto;
import com.training.project.repositories.MovieRepository;
import com.training.project.repositories.entities.MovieEntity;

@Service
public class MovieServices {
	
	private MovieRepository movieRepository;
	
	@Autowired
	public MovieServices(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
	}
	
	public MovieDto saveMovie(MovieDto movie) {
		 ModelMapper mapper=new ModelMapper();
		 MovieEntity movieEntity=mapper.map(movie,MovieEntity.class);
		MovieEntity returnedMovieEntity=this.movieRepository.save(movieEntity);
		MovieDto returnedMovieDto =mapper.map(returnedMovieEntity, MovieDto.class);
		return returnedMovieDto;
		 }
	
	public int deleteMovie(String movieName) {
		return movieRepository.deleteMovieByName(movieName);
	}
	
	
      public List<MovieDto> getAllMovies()
      {  
		ModelMapper mapper=new ModelMapper();
		Iterable<MovieEntity> listMovieEntity= this.movieRepository.findAll();
		List<MovieDto> listMovieDto=new ArrayList<MovieDto>();
		for(MovieEntity movieEntity: listMovieEntity) {
			MovieDto  movieDto=mapper.map(movieEntity,MovieDto.class);
			listMovieDto.add(movieDto);
		}
		return listMovieDto;
	}
      
}
