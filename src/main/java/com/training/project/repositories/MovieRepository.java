package com.training.project.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.training.project.repositories.entities.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

	
	Optional<MovieEntity> findByMovieName(String movieName);
	
	
	@Transactional
	@Modifying
	@Query("delete from MovieEntity e where e.movieName=?1")
	Integer deleteMovieByName(String movieName);
}
