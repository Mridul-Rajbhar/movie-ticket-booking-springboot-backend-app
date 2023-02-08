package com.training.project.web.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.dto.BookingDto;
import com.training.project.dto.MovieLanguage;
import com.training.project.dto.SeatsDto;
import com.training.project.repositories.entities.BookingEntity;
import com.training.project.repositories.entities.MovieEntity;
import com.training.project.services.BookingService;

@RestController
@RequestMapping("api/v1")
public class BookingController {

	private Logger logger = LoggerFactory.getLogger(BookingController.class);
	@Autowired
	private BookingService bookingService;
	
	public BookingController() {
		logger.info("Booking Controller constructor created");
	}
	
//	@CrossOrigin(origins="http://localhost:4200")
//	@PostMapping("booking/{movieName}")
//	public ResponseEntity<BookingDto> addBooking(@RequestBody BookingDto bookingDto, @PathVariable String movieName){
//		BookingDto returnedBookingDto = bookingService.saveBooking(bookingDto, movieName);
//		return new ResponseEntity<BookingDto>(returnedBookingDto, HttpStatus.CREATED);
//	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/booking/{id}")
	public ResponseEntity<BookingDto> getBookingById(@PathVariable Integer id){
		BookingDto returnedBookingDto = bookingService.findBookingById(id);
		return new ResponseEntity<BookingDto>(returnedBookingDto, HttpStatus.OK);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/booking")
	public ResponseEntity<List<BookingDto>> getAllBooking(){
		List<BookingDto> returnedListBookingDto = bookingService.findAllBookings();
		return new ResponseEntity<List<BookingDto>>(returnedListBookingDto, HttpStatus.OK);
	}

	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping(value="/booking/getSeats/{movieName}")
	public ResponseEntity<List<SeatsDto>> getAllBookingsForShow(@PathVariable("movieName")String movieName,
			@RequestParam String language, @RequestParam String movieFormat, 
			@RequestParam String bookingDate, @RequestParam String bookingTime) {
	MovieLanguage movieLanguage = MovieLanguage.valueOf(language);
	System.out.println("function called");
	List<SeatsDto> seatsToReturn =  this.bookingService.getSeatsForBooking(movieLanguage, movieFormat, LocalDate.parse(bookingDate),
			LocalTime.parse(bookingTime), movieName);
	return new ResponseEntity<List<SeatsDto>>(seatsToReturn, HttpStatus.OK);
	}
}
