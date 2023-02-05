package com.training.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.repositories.entities.SeatsEntity;

public interface SeatsRepository extends JpaRepository<SeatsEntity, Integer> {

}
