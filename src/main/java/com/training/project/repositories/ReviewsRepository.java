package com.training.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.project.repositories.entities.MovieEntity;
import com.training.project.repositories.entities.ReviewsEntity;
import com.training.project.repositories.entities.UsersEntity;

public interface ReviewsRepository extends JpaRepository<ReviewsEntity, Integer>{
	
	@Query("FROM ReviewsEntity r WHERE r.user=?1 and r.movie=?2")
	ReviewsEntity findReviewByUserAndMovie(UsersEntity user, MovieEntity movie);
	
}
