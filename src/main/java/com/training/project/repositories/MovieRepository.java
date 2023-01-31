package com.training.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.repositories.entities.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{
	MovieEntity getByMovieName(String movieName);
}
