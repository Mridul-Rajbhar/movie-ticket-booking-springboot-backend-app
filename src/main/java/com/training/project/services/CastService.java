package com.training.project.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.CastDto;
import com.training.project.dto.MovieDto;
import com.training.project.repositories.CastRepository;
import com.training.project.repositories.entities.CastEntity;
import com.training.project.repositories.entities.MovieEntity;

@Service
public class CastService {
	private CastRepository castRepository;
	
	@Autowired
	public CastService(CastRepository castRepository) {
	this.castRepository=castRepository;
	}
	
	public CastDto saveCast(CastDto cast) {
		ModelMapper mapper=new ModelMapper();
		CastEntity castEntity = mapper.map(cast,CastEntity.class);
		CastEntity returnedCastEntity=this.castRepository.save(castEntity);
		CastDto returnedCastDto =mapper.map(returnedCastEntity, CastDto.class);
		return returnedCastDto;
		}
	
	 public List<CastDto> findAll()
     {  
		ModelMapper mapper=new ModelMapper();
		Iterable<CastEntity> listCastEntity= this.castRepository.findAll();
		List<CastDto> listCastDto=new ArrayList<CastDto>();
		for(CastEntity castEntity: listCastEntity) 
		{
			CastDto  castDto=mapper.map(castEntity,CastDto.class);
			listCastDto.add(castDto);
		}
		return listCastDto;
	}
	
	
}
