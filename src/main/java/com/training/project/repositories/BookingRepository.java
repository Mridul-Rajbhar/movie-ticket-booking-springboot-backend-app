package com.training.project.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.project.dto.MovieLanguage;
import com.training.project.repositories.entities.BookingEntity;
import com.training.project.repositories.entities.MovieEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {
 
	@Query("from BookingEntity e where e.language=?1 and e.movieFormat = ?2  and  e.bookingDate=?3 and e.bookingTime=?4 and e.movie=?5")
    public List<BookingEntity> getBookingsForShow(MovieLanguage movieLanguage, String movieFormat,
LocalDate bookingDate, LocalTime bookingTime, MovieEntity movie);
	
}
