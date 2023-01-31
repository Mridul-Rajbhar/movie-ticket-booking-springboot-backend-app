package com.training.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.project.dto.Bank;
import com.training.project.repositories.entities.DiscountEntity;

public interface DiscountRepository extends JpaRepository<DiscountEntity, Integer> {
	DiscountEntity getByBankName(Bank bankName);
}
