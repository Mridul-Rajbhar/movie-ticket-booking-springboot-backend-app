package com.training.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.project.dto.MovieDto;
import com.training.project.repositories.MovieRepository;
import com.training.project.repositories.entities.MovieEntity;

@Service
public class MovieService {
	
	private MovieRepository movieRepository;
	
	@Autowired
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
	}
	
	public MovieDto saveMovie(MovieDto movie) {
		 ModelMapper mapper=new ModelMapper();
		 MovieEntity movieEntity=mapper.map(movie,MovieEntity.class);
		MovieEntity returnedMovieEntity=this.movieRepository.save(movieEntity);
		MovieDto returnedMovieDto =mapper.map(returnedMovieEntity, MovieDto.class);
		return returnedMovieDto;
		 }
	
	public MovieDto findMovieByName(String movieName) {
        ModelMapper mapper = new ModelMapper();
        MovieDto movieDto = null;
        Optional<MovieEntity> optional = this.movieRepository.findByMovieName(movieName);
        if(optional.isPresent()) {
            MovieEntity movieEntity =  optional.get();
             movieDto = mapper.map(movieEntity, MovieDto.class);
         }
        return movieDto;

    }
	
	public void deleteMovie(String movieName) {
		 movieRepository.deleteMovieByName(movieName);
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
