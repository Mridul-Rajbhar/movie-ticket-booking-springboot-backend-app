package com.training.project.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
import com.training.project.dto.MovieLanguage;
import com.training.project.dto.SeatsDto;
import com.training.project.repositories.BookingRepository;
import com.training.project.repositories.MovieRepository;
import com.training.project.repositories.SeatsRepository;
import com.training.project.repositories.entities.BookingEntity;
import com.training.project.repositories.entities.MovieEntity;
import com.training.project.repositories.entities.SeatsEntity;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private SeatsRepository seatsRepository;
	
	private ModelMapper mapper;
	private static Logger logger = LoggerFactory.getLogger(BookingEntity.class);
	
	public BookingService(){
		logger.info("booking service constructor created");
		mapper = new ModelMapper();
	}
	
	//create booking
	public BookingDto saveBooking(BookingDto bookingDto, String movieName) {
		
		//get movie by name
		MovieEntity movieToBook = this.movieRepository.getByMovieName(movieName);
		
		//convert booking dto to movie dto
		BookingEntity bookingEntity = mapper.map(bookingDto, BookingEntity.class);
		System.out.println("Booking entity: \n" + bookingEntity);
		bookingEntity.setMovie(movieToBook);
		
		List<SeatsEntity> seatToBooked = bookingEntity.getSeats();
		List<SeatsEntity> returnSeatWithId = new ArrayList<>(); 
		
		for(SeatsEntity seatsEntity: seatToBooked) {
			returnSeatWithId.add(this.seatsRepository.save(seatsEntity));
		}
		bookingEntity.setSeats(returnSeatWithId);
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
			
			List<BookingDto> bookingDtoList = new ArrayList<>();
			for(BookingEntity bookingEntity: bookings) {
				BookingDto bookingDto = mapper.map(bookingEntity, BookingDto.class);
				bookingDtoList.add(bookingDto);
				
			}
			return bookingDtoList;
			
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
