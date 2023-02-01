package com.training.project.repositories.entities;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.training.project.dto.MovieGenre;
import com.training.project.entities.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

	@Transactional
	@Modifying 
	@Query( "DELETE from MovieEntity e where e.movieName=?1")
	 Integer deleteMovieByName(String movieName);
	
	//To Get movie by name
	public MovieEntity getByMovieName(String name);
	
	// Pagination
	Page<MovieEntity> getByMovieGenre(MovieGenre movieGenre, Pageable pageable);
}
