package com.training.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.repositories.entities.ContactAddressEntity;
import com.training.project.repositories.entities.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
	UsersEntity getByContactAddress(ContactAddressEntity contactAddressEntity);
}
