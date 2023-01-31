package com.training.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.repositories.entities.ContactAddressEntity;

public interface ContactAddressRepository extends JpaRepository<ContactAddressEntity, Integer>{
	ContactAddressEntity getByEmail(String email);
}
