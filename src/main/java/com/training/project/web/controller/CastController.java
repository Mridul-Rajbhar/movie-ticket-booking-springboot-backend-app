package com.training.project.web.controller;

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

import com.training.project.dto.CastDto;
import com.training.project.services.CastService;

@RestController
@RequestMapping("api/v1")
public class CastController {
	private Logger logger = LoggerFactory.getLogger(CastController.class);
	@Autowired
	private CastService castService;
	
	public CastController() {
		logger.info("Cast Controller constructor created");
	}
	
	@PostMapping(value="cast")
	public ResponseEntity<CastDto> addCast(@RequestBody CastDto castDto){
		CastDto returnedCastDto = castService.saveCast(castDto);
		return new ResponseEntity<CastDto>(returnedCastDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/cast/{id}")
	public ResponseEntity<CastDto> getCast(@PathVariable Integer id){
		CastDto returnedCastDto = castService.findCastById(id);
		return new ResponseEntity<CastDto>(returnedCastDto, HttpStatus.OK);
	}
}
