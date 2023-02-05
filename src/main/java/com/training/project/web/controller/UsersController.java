package com.training.project.web.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.training.project.dto.UsersDto;
import com.training.project.services.UsersService;

@RestController
@RequestMapping("api/v1")
public class UsersController {

	private Logger logger = LoggerFactory.getLogger(UsersController.class);
	@Autowired
	private UsersService usersService;
	
	public UsersController() {
		logger.info("Users Controller constructor created");
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping(value="users")
	public ResponseEntity<UsersDto> addUsers(@RequestBody UsersDto usersDto){
		UsersDto returnedUserDto = usersService.saveUsers(usersDto);
		return new ResponseEntity<UsersDto>(returnedUserDto, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/users/{id}")
	public ResponseEntity<UsersDto> getUsers(@PathVariable Integer id){
		UsersDto returnedUsersDto = usersService.findUsersById(id);
		return new ResponseEntity<UsersDto>(returnedUsersDto, HttpStatus.OK);
	}

	
}
