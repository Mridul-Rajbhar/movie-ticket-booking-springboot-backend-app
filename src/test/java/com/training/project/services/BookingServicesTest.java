//package com.training.project.services;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.BDDMockito;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.training.project.dto.BookingDto;
//import com.training.project.dto.MovieLanguage;
//import com.training.project.dto.SeatsType;
//import com.training.project.repositories.BookingRepository;
//import com.training.project.repositories.entities.BookingEntity;
//import com.training.project.repositories.entities.SeatsEntity;
//
//
//@ExtendWith(MockitoExtension.class)
//public class BookingServicesTest {
//	
//	@Mock
//	private BookingRepository bookingRepository;
//	
//	@InjectMocks
//	private BookingService bookingService;
//	
//	
//@DisplayName("Junit test for get all bookings scenario")
//@Test
//public void givenBookingList_whenGetAllBooking_thenGetookingList() {
//
//	List<SeatsEntity> listSeats=new ArrayList<SeatsEntity>();	
//	 SeatsEntity seat1=new SeatsEntity('A',2,SeatsType.Premium);
//	 listSeats.add(seat1);
//	 
//	 BookingEntity booking1=new BookingEntity(MovieLanguage.English,"3D",LocalDate.now(),LocalTime.now());
//	 booking1.setSeats(listSeats); 
//	 bookingRepository.save(booking1);
//	 
//	 List<SeatsEntity> listSeats2=new ArrayList<SeatsEntity>();	
//	 SeatsEntity seat2=new SeatsEntity('B',5,SeatsType.Gold);
//	 listSeats.add(seat1);
//	 
//	 BookingEntity booking2=new BookingEntity(MovieLanguage.Hindi,"2D",LocalDate.now(),LocalTime.now());
//	 booking2.setSeats(listSeats2); 
//	 bookingRepository.save(booking2);
//	 
//	 BDDMockito.given(bookingRepository.findAll()).willReturn(List.of(booking1 , booking2));
//
//		// when
//		List<BookingDto> book = bookingService.getAllBookings();
//
//		// then
//		//Assertions.assertThat(book).isNotNull();
//		Assertions.assertThat(book.size()).isEqualTo(2);
//		
//
//}
//}
