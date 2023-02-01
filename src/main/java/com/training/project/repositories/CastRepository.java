package com.training.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.repositories.entities.CastEntity;

public interface CastRepository extends JpaRepository<CastEntity, Integer>{
	CastEntity getByCastName(String name);
}
