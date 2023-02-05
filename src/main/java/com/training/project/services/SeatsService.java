package com.training.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.ReviewsDto;
import com.training.project.dto.SeatsDto;
import com.training.project.repositories.BookingRepository;
import com.training.project.repositories.SeatsRepository;
import com.training.project.repositories.entities.BookingEntity;
import com.training.project.repositories.entities.ReviewsEntity;
import com.training.project.repositories.entities.SeatsEntity;

@Service
public class SeatsService {
	@Autowired
	private SeatsRepository seatsRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	private ModelMapper mapper;
	private static Logger logger = LoggerFactory.getLogger(ReviewsEntity.class);
	
	public SeatsService() {
		// TODO Auto-generated constructor stub
		mapper = new ModelMapper();
		logger.info("seatsService constructor called");
	}
	
	//post seats
	public SeatsDto saveSeats(SeatsDto seatsDto, Integer bookingId) {
		SeatsEntity seatsEntity = mapper.map(seatsDto, SeatsEntity.class);
		Optional<BookingEntity> checkBookingEntity = this.bookingRepository.findById(bookingId);
		BookingEntity bookingEntity = checkBookingEntity!=null?checkBookingEntity.get():null;
		seatsEntity.setBooking(bookingEntity);
//		System.out.println(seatsEntity);
		SeatsEntity returnedSeatsEntity = seatsRepository.save(seatsEntity);
		SeatsDto seatDtoToReturn = mapper.map(returnedSeatsEntity, SeatsDto.class);
		return seatDtoToReturn;
	}
	
	//get all seats
	public List<SeatsDto> getAllSeats()
	{
		ModelMapper mapper=new ModelMapper();
		Iterable<SeatsEntity> listSeatsEntity= this.seatsRepository.findAll();
		List<SeatsDto> listSeatsDto=new ArrayList<SeatsDto>();
		for(SeatsEntity seatsEntity: listSeatsEntity) {
			SeatsDto seatsDto=mapper.map(seatsEntity,SeatsDto.class);
			listSeatsDto.add(seatsDto);
		}
		return listSeatsDto;
	}


	
	
	//get single seat
	public SeatsDto findSeatsByID(Integer id) {
	       ModelMapper mapper = new ModelMapper();
	       SeatsDto seatsDto = null;
	       Optional<SeatsEntity> optional =  this.seatsRepository.findById(id);
	       if(optional.isPresent()) {
	           SeatsEntity seatsEntity =  optional.get();
	          seatsDto = mapper.map(seatsEntity, SeatsDto.class);
	        }
	       return seatsDto;
		}
}
