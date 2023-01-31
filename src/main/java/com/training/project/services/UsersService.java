package com.training.project.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.UsersDto;
import com.training.project.repositories.UsersRepository;
import com.training.project.repositories.entities.UsersEntity;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	private ModelMapper mapper;
	private static Logger logger = LoggerFactory.getLogger(UsersEntity.class);
	
	public UsersService() {
		// TODO Auto-generated constructor stub
		logger.info("users service constructor created");
		mapper = new ModelMapper();
	}
	
	//create users
	public UsersDto saveUsers(UsersDto usersDto) {
		UsersEntity usersEntity = mapper.map(usersDto, UsersEntity.class);
		UsersEntity returnedUsersEntity = usersRepository.save(usersEntity);
		UsersDto returnUsersDto = mapper.map(returnedUsersEntity, UsersDto.class);
		return returnUsersDto;
	}
	
		//get users
		public UsersDto findUsersById(Integer userId) {
			Optional<UsersEntity> checkUsersEntity = this.usersRepository.findById(userId);
			UsersDto usersDto = null;
			if(checkUsersEntity.isPresent()) {
				UsersEntity returnedUserEntity =  checkUsersEntity.get();
				usersDto = mapper.map(returnedUserEntity, UsersDto.class);
			}	
			return usersDto;
		}

}
