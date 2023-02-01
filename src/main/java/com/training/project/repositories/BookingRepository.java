package com.training.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.repositories.entities.BookingEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

}
