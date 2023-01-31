package com.training.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.repositories.entities.ReviewsEntity;

public interface ReviewsRepository extends JpaRepository<ReviewsEntity, Integer>{

}
