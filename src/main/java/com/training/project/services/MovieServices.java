package com.training.project.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.training.project.dto.MovieDTO;
import com.training.project.dto.MovieGenre;
import com.training.project.entities.MovieEntity;
import com.training.project.repositories.entities.MovieRepository;

@Service
public class MovieServices {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public MovieServices(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
	}
	
	// Save Movie
	public MovieDTO saveMovie(MovieDTO movie) {
		ModelMapper mapper = new ModelMapper();
		
		//Converting MovieDTO Object into entity
		MovieEntity movieEntity =  mapper.map(movie, MovieEntity.class);
		
		//Persist the converted data into database
		MovieEntity returnedMovieEntity = this.movieRepository.save(movieEntity);
		
		//Converting returned entity object into DTO for return
		MovieDTO returnedMovieDTO =  mapper.map(returnedMovieEntity, MovieDTO.class);
		
		return returnedMovieDTO;
	}

	// get movie
	public List<MovieDTO> getMovie(){
		
		ModelMapper mapper = new ModelMapper();
		
		Iterable<MovieEntity> listMovieEntity = this.movieRepository.findAll();
		
		List<MovieDTO> listMovieDTO = new ArrayList<MovieDTO>();
		
		for (MovieEntity movieEntity : listMovieEntity) {
			MovieDTO movieDTO = mapper.map(movieEntity, MovieDTO.class);
			listMovieDTO.add(movieDTO);
		}
		
		return listMovieDTO;
		
	}
	
	// delete movie by name
	public int deleteMovie(String movieName) {
		return movieRepository.deleteMovieByName(movieName);
	}
	
	
	// get movie by name
	public MovieDTO findMovieByName(String name) {
		ModelMapper mapper = new ModelMapper();
		MovieEntity movieFound = this.movieRepository.getByMovieName(name);
		MovieDTO movieToReturn = mapper.map(movieFound, MovieDTO.class);
		return movieToReturn;
	}

	//Pagination
	public Page<MovieDTO> getMoviePagination(Integer pageNumber, Integer pageSize) {
		ModelMapper mapper = new ModelMapper();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<MovieDTO> pageMovieDTO = movieRepository.findAll(pageable).map(
				movieEntity -> mapper.map(movieEntity, MovieDTO.class));
		return pageMovieDTO;
	}
	
	//Sorting based on MovieGenre
	public Page<MovieDTO> getMovieByGenrePagination(MovieGenre movieGenre, Integer pageNumber, Integer pageSize) {
		ModelMapper mapper = new ModelMapper();
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<MovieDTO> pageMovieDTO = movieRepository.getByMovieGenre(movieGenre, pageable).map(
				movieEntity -> mapper.map(movieEntity, MovieDTO.class));
		return pageMovieDTO;
	}
	
	
}
