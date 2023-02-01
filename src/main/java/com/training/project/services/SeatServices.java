package com.training.project.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.BookingDto;
import com.training.project.dto.MovieDto;
import com.training.project.dto.SeatsDto;
import com.training.project.repositories.SeatsRepository;
import com.training.project.repositories.entities.BookingEntity;
import com.training.project.repositories.entities.MovieEntity;
import com.training.project.repositories.entities.SeatsEntity;

@Service
public class SeatServices {
 
	private SeatsRepository seatsRepository;
	@Autowired
	public SeatServices(SeatsRepository seatsRepository) {
		this.seatsRepository=seatsRepository;
	}
	
	public SeatsDto saveSeats(SeatsDto seats) {
		ModelMapper mapper=new ModelMapper();
		 SeatsEntity seatsEntity=mapper.map(seats, SeatsEntity.class);
		 SeatsEntity returnedSeatsEntity=this.seatsRepository.save(seatsEntity);
		SeatsDto retunedSeatsDto = mapper.map(returnedSeatsEntity, SeatsDto.class);
		return retunedSeatsDto;
	}
	
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
	
	public List<SeatsDto> getAllSeats()
    {  
		ModelMapper mapper=new ModelMapper();
		Iterable<SeatsEntity> listSeatsEntity= this.seatsRepository.findAll();
		List<SeatsDto> listSeatsDto=new ArrayList<SeatsDto>();
		for(SeatsEntity seatsEntity: listSeatsEntity) {
			SeatsDto  seatsDto=mapper.map(seatsEntity,SeatsDto.class);
			listSeatsDto.add(seatsDto);
		}
		return listSeatsDto;
	}
}



