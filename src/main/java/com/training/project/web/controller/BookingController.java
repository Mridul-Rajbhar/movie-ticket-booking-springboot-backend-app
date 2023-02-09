package com.training.project.web.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
import com.training.project.dto.MovieDto;
import com.training.project.dto.MovieLanguage;
import com.training.project.dto.SeatsDto;
import com.training.project.services.BookingService;
import com.training.project.services.MovieService;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

	private BookingService bookingServices;
	 
	public BookingController(BookingService bookingServices) {
		this.bookingServices=bookingServices;
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping("/bookings")
	public ResponseEntity<List<BookingDto>> getBookings(){	
		List<BookingDto> list=this.bookingServices.getAllBookings();
		return ResponseEntity.ok(list);
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@PostMapping(value = "/bookings")
	 public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto booking)
	{
	 // complete the code and return ResponseEnity object with status code 201
	    BookingDto returnedBookingDto =this.bookingServices.saveBooking(booking);
	    return new ResponseEntity<BookingDto>(returnedBookingDto, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping(value="/bookings/{id}" ,produces="application/json")
	public ResponseEntity<BookingDto> findBookingById(@PathVariable("id") int bookingId){
		this.bookingServices.findBookingByID(bookingId);
		BookingDto bookingDTO= this.bookingServices.findBookingByID(bookingId);
		return ResponseEntity.ok(bookingDTO);
	}
	

	@CrossOrigin(origins="http://localhost:4200/")
	@GetMapping(value="/booking/getSeats/{movieName}")
	public ResponseEntity<List<SeatsDto>> getAllBookingsForShow(@PathVariable("movieName")String movieName,
			@RequestParam String language, @RequestParam String movieFormat, 
			@RequestParam String bookingDate, @RequestParam String bookingTime) {
	MovieLanguage movieLanguage = MovieLanguage.valueOf(language);
	System.out.println("function called");
	List<SeatsDto> seatsToReturn =  this.bookingServices.getSeatsForBooking(movieLanguage, movieFormat, LocalDate.parse(bookingDate), LocalTime.parse(bookingTime), movieName);
	return new ResponseEntity<List<SeatsDto>>(seatsToReturn, HttpStatus.OK);
	}
}
