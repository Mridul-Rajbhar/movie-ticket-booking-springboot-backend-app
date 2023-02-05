package com.training.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.repositories.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
	
}
