package com.training.project.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.BookingDto;
import com.training.project.dto.MovieDto;
import com.training.project.repositories.BookingRepository;
import com.training.project.repositories.MovieRepository;
import com.training.project.repositories.entities.BookingEntity;
import com.training.project.repositories.entities.MovieEntity;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	private ModelMapper mapper;
	private static Logger logger = LoggerFactory.getLogger(BookingEntity.class);
	
	public BookingService(){
		logger.info("booking service constructor created");
		mapper = new ModelMapper();
	}
	
	//create booking
	public BookingDto saveBooking(BookingDto bookingDto, String movieName) {
		
		MovieEntity movieToBook = this.movieRepository.getByMovieName(movieName);
		
		System.out.println(bookingDto);
		BookingEntity bookingEntity = mapper.map(bookingDto, BookingEntity.class);
		System.out.println(bookingEntity);
		bookingEntity.setMovie(movieToBook);
		BookingEntity returnedbookingEntity = bookingRepository.save(bookingEntity);
		BookingDto returnedBookingDto = mapper.map(returnedbookingEntity, BookingDto.class);
		
		logger.info("created booking dto object");
		return returnedBookingDto;
	}
	
	//get booking
		public BookingDto findBookingById(Integer bookingId) {
			
			logger.info("found by id called");
			Optional<BookingEntity> checkBookingEntity = this.bookingRepository.findById(bookingId);
			
			BookingDto bookingDto = null;
			if(checkBookingEntity.isPresent()) {
				BookingEntity returnedBookingEntity =  checkBookingEntity.get();
				bookingDto = mapper.map(returnedBookingEntity, BookingDto.class);
				}	
			
			logger.info("found booking id");
			return bookingDto;
			}
		
		//get all bookings
		public List<BookingDto> findAllBookings() {
			logger.info("found all bookings called");
			Iterable<BookingEntity> bookings = this.bookingRepository.findAll();
			
			List<BookingDto> bookingDtoList = null;
			for(BookingEntity bookingEntity: bookings) {
				BookingDto bookingDto = mapper.map(bookingEntity, BookingDto.class);
				bookingDtoList.add(bookingDto);
				
			}
			return bookingDtoList;
			
		}
	
}
