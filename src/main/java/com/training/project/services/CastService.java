package com.training.project.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.CastDto;
import com.training.project.repositories.CastRepository;
import com.training.project.repositories.entities.CastEntity;

@Service
public class CastService {
	
	@Autowired
	public CastRepository castRepository;
	private ModelMapper mapper;
	private static Logger logger = LoggerFactory.getLogger(CastEntity.class);
	
	public CastService(){
		logger.info("cast service contructor created");
		mapper = new ModelMapper();
	}
	
	//create cast
	public CastDto saveCast(CastDto castDto) {
		CastEntity castEntity = mapper.map(castDto, CastEntity.class);
		CastEntity returnedCastEntity = castRepository.save(castEntity);
		CastDto returnedMovieDto = mapper.map(returnedCastEntity, CastDto.class);
		return returnedMovieDto;
	}
	
	//get cast
	public CastDto findCastById(Integer castId) {
		Optional<CastEntity> checkCastEntity = this.castRepository.findById(castId);
		CastDto castDto = null;
		if(checkCastEntity.isPresent()) {
			CastEntity returnedCastEntity =  checkCastEntity.get();
			castDto = mapper.map(returnedCastEntity, CastDto.class);
			}	
		return castDto;
		}
}
