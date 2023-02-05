package com.training.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.Bank;
import com.training.project.dto.DiscountDto;
import com.training.project.repositories.DiscountRepository;
import com.training.project.repositories.entities.DiscountEntity;

@Service
public class DiscountService {

	@Autowired
	private DiscountRepository discountRepository;
	private ModelMapper mapper;
	private static Logger logger = LoggerFactory.getLogger(DiscountEntity.class);
	
	public DiscountService(){
		logger.info("discount service constructor created");
		mapper = new ModelMapper();
	}
	
	//get all discount objects
	public List<DiscountDto> getAll(){
		Iterable<DiscountEntity> discountEntitys = this.discountRepository.findAll();
		List<DiscountDto> discountDtos = new ArrayList<DiscountDto>();
		for(DiscountEntity discountEntity: discountEntitys) {
			DiscountDto discountDto = mapper.map(discountEntity, DiscountDto.class);
			discountDtos.add(discountDto);
		}
		return discountDtos;
	}
	
	
	//create discount object
	public DiscountDto saveDiscount(DiscountDto discountDto) {
		DiscountEntity discountEntity = mapper.map(discountDto, DiscountEntity.class);
		DiscountEntity returnedDiscountEntity = discountRepository.save(discountEntity);
		DiscountDto returnedDiscountDto = mapper.map(returnedDiscountEntity, DiscountDto.class);
		
		logger.info("created discount dto object");
		return returnedDiscountDto;
	}
	
	//get discount object by id
		public DiscountDto getDiscountById(Integer discountId) {
			Optional<DiscountEntity> checkDiscountEntity = this.discountRepository.findById(discountId);
			DiscountDto discountDto = null;
			if(checkDiscountEntity.isPresent()) {
				DiscountEntity returnedDiscountEntity =  checkDiscountEntity.get();
				discountDto = mapper.map(returnedDiscountEntity, DiscountDto.class);
				}	
			return discountDto;
			}

	
	public DiscountDto getDiscountByBankname(Bank bankName) {
		DiscountEntity discountEntity =this.discountRepository.getByBankName(bankName);
		DiscountDto returnedDiscountDto = mapper.map(discountEntity, DiscountDto.class);
		 return returnedDiscountDto;
	}
		
	//update Discount 
	public DiscountDto updateDiscountByBankName(DiscountDto discountDto) {
		DiscountEntity discountEntity = this.discountRepository.getByBankName(discountDto.getBankName());
		discountEntity.setDiscountPercentage(discountDto.getDiscountPercentage());
		DiscountEntity returnedDiscountEntity = this.discountRepository.save(discountEntity);
		DiscountDto returnedDiscountDto = mapper.map(returnedDiscountEntity, DiscountDto.class);
		
		return returnedDiscountDto;
		
	}
	
}
