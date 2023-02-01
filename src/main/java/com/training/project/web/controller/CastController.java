package com.training.project.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.dto.CastDto;
import com.training.project.dto.MovieDto;
import com.training.project.services.CastServices;

@RestController
@RequestMapping("/api/c1")
public class CastController {
	
	private CastServices castServices;
	public CastController(CastServices castServices) {
		this.castServices=castServices;
	}
	
	@GetMapping("/cast")
	public ResponseEntity<List<CastDto>> getCast(){	
		List<CastDto> list=this.castServices.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping(value = "/cast", consumes = "application/json", produces = "application/json")
	 public ResponseEntity<CastDto> createCast(@RequestBody CastDto cast)
	{
	 // complete the code and return ResponseEnity object with status code 201
	    CastDto returnedCastDto =this.castServices.saveCast(cast);
	    return new ResponseEntity<CastDto>(returnedCastDto, HttpStatus.CREATED);
	}
	
	
	

	
}
