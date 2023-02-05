package com.training.project.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.dto.ReviewsDto;
import com.training.project.dto.SeatsDto;
import com.training.project.services.SeatsService;

@RestController
@RequestMapping("api/v1")
public class SeatsController {
	@Autowired
	private SeatsService seatsService;
	
	@PostMapping(value="/seats/{bookingId}")
	public ResponseEntity<SeatsDto> addSeats(@RequestBody SeatsDto seatsDto, @PathVariable Integer bookingId){
		SeatsDto returnedSeatsDto = this.seatsService.saveSeats(seatsDto, bookingId);
		return new ResponseEntity<SeatsDto>(returnedSeatsDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/seats/{id}")
	public ResponseEntity<SeatsDto> getSeatsById(@PathVariable Integer id){
		SeatsDto returnedSeatsDto = this.seatsService.findSeatsByID(id);
		return new ResponseEntity<SeatsDto>(returnedSeatsDto, HttpStatus.OK);
	}
	
}
