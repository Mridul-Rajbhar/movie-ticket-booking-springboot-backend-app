package com.training.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.training.project.dto.MovieDto;
import com.training.project.dto.MovieGenre;
import com.training.project.dto.ReviewsDto;
import com.training.project.repositories.MovieRepository;
import com.training.project.repositories.entities.MovieEntity;
import com.training.project.repositories.entities.ReviewsEntity;

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
	
	//getAllMovies
	public List<MovieDto> getAllMovies(){
		Iterable<MovieEntity> allMoviesEntity = this.movieRepository.findAll();
		List<MovieDto> movieDtosToReturn = new ArrayList<>();
		for(MovieEntity movieEntity: allMoviesEntity) {
			MovieDto movieDto = mapper.map(movieEntity, MovieDto.class);
			movieDtosToReturn.add(movieDto);
		}
		
		return movieDtosToReturn;
	}
	
	//create movie
	public MovieDto saveMovie(MovieDto movieDto) {
		logger.info("save Movie function called");
		MovieEntity movieEntity = mapper.map(movieDto, MovieEntity.class);
		MovieEntity returnedMovieEntity = movieRepository.save(movieEntity);
		MovieDto returnedMovieDto = mapper.map(returnedMovieEntity, MovieDto.class);
		return returnedMovieDto;
	}
	
	//get movie by id
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
	
	//get all movie reviews
	public List<ReviewsDto> getAllReviewsForMovie(String movieName){
		MovieEntity movieEntityFound = this.movieRepository.getByMovieName(movieName);
		List<ReviewsEntity> movieReviews = movieEntityFound.getReviews();
		List<ReviewsDto> movieReviewsDtoToReturn = new ArrayList<>();
		for(ReviewsEntity reviewsEntity: movieReviews) {
			ReviewsDto reviewsDto = mapper.map(reviewsEntity, ReviewsDto.class);
			movieReviewsDtoToReturn.add(reviewsDto);
		}
		
		return movieReviewsDtoToReturn;
	}
	
	//delete movie by name
	public void deleteMovie(String movieName) {
		movieRepository.deleteMovieByName(movieName);
	}

	//Pagination
		public Page<MovieDto> getMoviePagination(Integer pageNumber, Integer pageSize) {
			ModelMapper mapper = new ModelMapper();
			Pageable pageable = PageRequest.of(pageNumber, pageSize);
			Page<MovieDto> pageMovieDTO = movieRepository.findAll(pageable).map(
					movieEntity -> mapper.map(movieEntity, MovieDto.class));
			return pageMovieDTO;
		}
		
		//Sorting based on MovieGenre
		public Page<MovieDto> getMovieByGenrePagination(MovieGenre movieGenre, Integer pageNumber, Integer pageSize) {
			ModelMapper mapper = new ModelMapper();
			Pageable pageable = PageRequest.of(pageNumber, pageSize);
			Page<MovieDto> pageMovieDTO = movieRepository.getByMovieGenre(movieGenre, pageable).map(
					movieEntity -> mapper.map(movieEntity, MovieDto.class));
			return pageMovieDTO;
		}

}
