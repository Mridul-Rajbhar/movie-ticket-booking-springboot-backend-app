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

import com.training.project.dto.OrderDto;
import com.training.project.services.OrderService;

@RestController
@RequestMapping("api/v1")
public class OrderController {
	
	
	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderService orderService;
	
	public OrderController() {
		logger.info("Order Controller constructor created");
	}
	
	@PostMapping(value="/{userEmail}/{movieName}/orders")
	public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto, @PathVariable String userEmail,
			@PathVariable String movieName){
		OrderDto returnedOrderDto = orderService.saveOrder(orderDto, userEmail, movieName);
		return new ResponseEntity<OrderDto>(returnedOrderDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<OrderDto> getOrder(@PathVariable Integer id){
		OrderDto returnedOrderDto = orderService.findOrderById(id);
		return new ResponseEntity<OrderDto>(returnedOrderDto, HttpStatus.OK);
	}
}
