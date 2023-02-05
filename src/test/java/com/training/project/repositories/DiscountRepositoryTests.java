package com.training.project.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.training.project.dto.Bank;
import com.training.project.repositories.entities.DiscountEntity;

@DataJpaTest
@ActiveProfiles("tests")
public class DiscountRepositoryTests {
	@Autowired
	private DiscountRepository discountRepository;
	
	@Test
	public void update_disocunt_change_discount_percentage() {
		//setup
		DiscountEntity discountEntity5Percentage = new DiscountEntity(Bank.Axis, 5.0);
		//save discount before update
		discountRepository.save(discountEntity5Percentage);
		System.out.println(discountEntity5Percentage);
		
		//when-action to test
		DiscountEntity discountToUpdate = this.discountRepository.getByBankName(Bank.Axis);
		discountToUpdate.setDiscountPercentage(2.0);
		
		
		//then verification
		DiscountEntity updatedVersion = this.discountRepository.save(discountToUpdate);
		System.out.println(updatedVersion);
		assertThat(updatedVersion).isNotNull();
		assertThat(updatedVersion.getDiscountPercentage()).isEqualTo(2.00);
	}
}
