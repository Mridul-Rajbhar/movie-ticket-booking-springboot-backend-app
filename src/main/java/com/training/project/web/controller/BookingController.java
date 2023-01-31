package com.training.project.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.dto.BookingDto;
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
	
	@PostMapping("booking/{movieName}")
	public ResponseEntity<BookingDto> addBooking(@RequestBody BookingDto bookingDto, @PathVariable String movieName){
		BookingDto returnedBookingDto = bookingService.saveBooking(bookingDto, movieName);
		return new ResponseEntity<BookingDto>(returnedBookingDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/booking/{id}")
	public ResponseEntity<BookingDto> getBooking(@PathVariable Integer id){
		BookingDto returnedBookingDto = bookingService.findBookingById(id);
		return new ResponseEntity<BookingDto>(returnedBookingDto, HttpStatus.OK);
	}
	
	@GetMapping("/booking")
	public ResponseEntity<List<BookingDto>> getAllBooking(){
		List<BookingDto> returnedListBookingDto = bookingService.findAllBookings();
		return new ResponseEntity<List<BookingDto>>(returnedListBookingDto, HttpStatus.OK);
	}

	
}
