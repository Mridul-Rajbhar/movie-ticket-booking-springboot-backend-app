package com.training.project.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.project.dto.Bank;
import com.training.project.dto.DiscountDto;
import com.training.project.services.DiscountService;

@RequestMapping("api/v1")
@RestController
public class DiscountController {

	private Logger logger = LoggerFactory.getLogger(DiscountController.class);
	@Autowired
	private DiscountService discountService;
	
	public DiscountController() {
		logger.info("Discount Controller constructor created");
	}
	
	@PostMapping(value="discount")
	public ResponseEntity<DiscountDto> addDiscount(@RequestBody DiscountDto discountDto){
		DiscountDto returnedDiscountDto = this.discountService.saveDiscount(discountDto);
		return new ResponseEntity<DiscountDto>(returnedDiscountDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/discount/{id}")
	public ResponseEntity<DiscountDto> getDiscount(@PathVariable Integer id){
		DiscountDto returnedDiscountDto = this.discountService.getDiscountById(id);
		System.out.println(returnedDiscountDto);
		return new ResponseEntity<DiscountDto>(returnedDiscountDto, HttpStatus.OK);
	}
	
	@PutMapping("/discount/{bankName}")
	public ResponseEntity<DiscountDto> findDiscount(@PathVariable String bankName, @RequestParam float discount){
		Bank bank = Bank.valueOf(bankName);
		DiscountDto returnedDiscountDto = this.discountService.findDiscountByBankName(bank, discount);
		return new ResponseEntity<DiscountDto>(returnedDiscountDto, HttpStatus.OK);
	}

}
