package com.training.project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.training.project.repositories.entities.BookingEntity;

public interface BookingRepository extends CrudRepository<BookingEntity, Integer>{

}
