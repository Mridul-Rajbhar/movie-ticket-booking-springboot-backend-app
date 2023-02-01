package com.training.project.web.controller;

import java.util.List;

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
import com.training.project.dto.SeatsDto;
import com.training.project.services.SeatServices;

@RestController
@RequestMapping("/api/s1")
public class SeatsController {
	private SeatServices seatsServices;
	
	@Autowired
	public SeatsController(SeatServices seatsServices) {
		this.seatsServices=seatsServices;
	}
  
	@GetMapping("/seats")
	public ResponseEntity<List<SeatsDto>> getSeats(){	
		List<SeatsDto> list=this.seatsServices.getAllSeats();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping(value = "/seats")
	 public ResponseEntity<SeatsDto> createSeats(@RequestBody SeatsDto seats)
	{
	    SeatsDto returnedSeatsDto =this.seatsServices.saveSeats(seats);
	    return new ResponseEntity<SeatsDto>(returnedSeatsDto, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/seats/{id}" ,produces="application/json")
	public ResponseEntity<SeatsDto> findSeatsById(@PathVariable("id") int seatsId){
		this.seatsServices.findSeatsByID(seatsId);
		SeatsDto seatsDTO= this.seatsServices.findSeatsByID(seatsId);
		return ResponseEntity.ok(seatsDTO);
		
	}
}
