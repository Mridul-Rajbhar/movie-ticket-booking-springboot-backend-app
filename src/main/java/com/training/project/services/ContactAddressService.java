package com.training.project.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.ContactAddressDto;
import com.training.project.repositories.ContactAddressRepository;
import com.training.project.repositories.entities.ContactAddressEntity;

@Service
public class ContactAddressService {
	@Autowired
	private ContactAddressRepository contactAddressRepository;
	
	private ModelMapper mapper;
	private static Logger logger = LoggerFactory.getLogger(ContactAddressEntity.class);
	
	public ContactAddressService(){
		logger.info("contact address service constructor created");
		mapper = new ModelMapper();
	}
	
	//create contact address
	public ContactAddressDto saveContactAddress(ContactAddressDto contactAddressDto) {
		ContactAddressEntity contactAddressEntity = mapper.map(contactAddressDto, ContactAddressEntity.class);
		ContactAddressEntity returnedContactAddressEntity = contactAddressRepository.save(contactAddressEntity);
		ContactAddressDto returnedBookingDto = mapper.map(returnedContactAddressEntity, ContactAddressDto.class);
		
		logger.info("created contact address dto object");
		return returnedBookingDto;
	}
	
	//get contact address
		public ContactAddressDto findContactAddressById(Integer contactAddressId) {
			Optional<ContactAddressEntity> checkContactAddressEntity = this.contactAddressRepository.findById(contactAddressId);
			ContactAddressDto contactAddressDto = null;
			if(checkContactAddressEntity.isPresent()) {
				ContactAddressEntity returnedContactAddressEntity =  checkContactAddressEntity.get();
				contactAddressDto = mapper.map(returnedContactAddressEntity, ContactAddressDto.class);
				}	
			return contactAddressDto;
			}
	
}
