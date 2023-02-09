package com.training.project.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.training.project.dto.BookingDto;
import com.training.project.dto.MovieDto;
import com.training.project.dto.MovieLanguage;
import com.training.project.dto.SeatsDto;
import com.training.project.repositories.BookingRepository;
import com.training.project.repositories.MovieRepository;
import com.training.project.repositories.entities.BookingEntity;
import com.training.project.repositories.entities.MovieEntity;
import com.training.project.repositories.entities.SeatsEntity;

@Service
public class BookingService {
	
	private BookingRepository bookingRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository=bookingRepository;
	}
	
   public BookingDto saveBooking(BookingDto booking) {
	   ModelMapper mapper=new ModelMapper();
	   BookingEntity bookingEntity=mapper.map(booking,BookingEntity.class);
	   BookingEntity returnedbookingEntity = this.bookingRepository.save(bookingEntity);
	    BookingDto returnedBookingDto=mapper.map(returnedbookingEntity, BookingDto.class);
	    return returnedBookingDto;
   }
   
   public List<BookingDto> getAllBookings()
   {  
  	ModelMapper mapper=new ModelMapper();
  	Iterable<BookingEntity> listBookingEntity= this.bookingRepository.findAll();
  	List<BookingDto> listBookingDto=new ArrayList<BookingDto>();
  	for(BookingEntity bookingEntity: listBookingEntity) {
  		BookingDto  bookingDto=mapper.map(bookingEntity,BookingDto.class);
  		listBookingDto.add(bookingDto);
  	}
  	return listBookingDto;
  }
   
   public BookingDto findBookingByID(Integer id) {
       ModelMapper mapper = new ModelMapper();
       BookingDto bookingDto = null;
       Optional<BookingEntity> optional =  this.bookingRepository.findById(id);
       if(optional.isPresent()) {
           BookingEntity bookingEntity =  optional.get();
          bookingDto = mapper.map(bookingEntity, BookingDto.class);
        }
       return bookingDto;
        }
   
   
   public List<SeatsDto> getSeatsForBooking(MovieLanguage movieLanguage, String movieFormat,
		   LocalDate bookingDate, LocalTime bookingTime, String movieName){
	   ModelMapper mapper = new ModelMapper();
	   
	   MovieEntity searchedMovie = this.movieRepository.findByMovieName(movieName).get();
	   List<BookingEntity> bookingListForShow = this.bookingRepository.getBookingsForShow(movieLanguage,
			   movieFormat, bookingDate, bookingTime, searchedMovie);
	   
	   List<SeatsDto> listOfSeatsToReturn = new ArrayList<>();
	   for(BookingEntity bookingEntity: bookingListForShow) {
		   BookingDto bookingDto = mapper.map(bookingEntity, BookingDto.class);
		   listOfSeatsToReturn.addAll(bookingDto.getSeats());
	   }
	   return listOfSeatsToReturn;
   }

   



}




