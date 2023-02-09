package com.training.project.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.training.project.dto.MovieGenre;
import com.training.project.dto.MovieLanguage;
import com.training.project.dto.SeatsType;
import com.training.project.repositories.entities.BookingEntity;
import com.training.project.repositories.entities.CastEntity;
import com.training.project.repositories.entities.MovieEntity;
import com.training.project.repositories.entities.SeatsEntity;

@ActiveProfiles("test")
@DataJpaTest
public class BookingRepositoryTests {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Test
	public void givenBookingObject_whenSaved_thenNewBookingCreated() {
		//given-precondition order
	List<SeatsEntity> listSeats=new ArrayList<SeatsEntity>();	
	SeatsEntity seat1=new SeatsEntity('A',2,SeatsType.Premium);
	listSeats.add(seat1);
	BookingEntity booking1=new BookingEntity(MovieLanguage.English,"3D",LocalDate.now(),LocalTime.now());
	booking1.setSeats(listSeats); 
	
		//when-action or the behaviour we are testing
	  BookingEntity newCreatedBooking= bookingRepository.save(booking1);
		//then-verify the output
	 Assertions.assertThat(newCreatedBooking).isNotNull(); 
	}
	
	
	@DisplayName("Junit test for get all bookings (positive) scenario")
	@Test
	public void givenBookingList_whenGetAllBookings_thenGetBookingList() {

		// given - precondition or setup
		
		List<SeatsEntity> listSeats=new ArrayList<SeatsEntity>();	
		 SeatsEntity seat1=new SeatsEntity('A',2,SeatsType.Premium);
		 listSeats.add(seat1);
		 
		 BookingEntity booking1=new BookingEntity(MovieLanguage.English,"3D",LocalDate.now(),LocalTime.now());
		 booking1.setSeats(listSeats); 
		 bookingRepository.save(booking1);
		 
		 List<SeatsEntity> listSeats2=new ArrayList<SeatsEntity>();	
		 SeatsEntity seat2=new SeatsEntity('B',5,SeatsType.Gold);
		 listSeats.add(seat1);
		 
		 BookingEntity booking2=new BookingEntity(MovieLanguage.Hindi,"2D",LocalDate.now(),LocalTime.now());
		 booking2.setSeats(listSeats2); 
		 bookingRepository.save(booking2);
		 
		// when
		List<BookingEntity> bookings = bookingRepository.findAll();

		// then
		Assertions.assertThat(bookings).isNotNull();
		Assertions.assertThat(bookings.size()).isEqualTo(2);
	}


}