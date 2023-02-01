package com.training.project.repositories.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.entities.ReviewsEntity;

public interface ReviewsRepository extends JpaRepository<ReviewsEntity, Integer> {

}
