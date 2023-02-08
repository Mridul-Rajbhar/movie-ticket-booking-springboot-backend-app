package com.training.project.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("JUNIT test for updating discount by changing discount percentage")
	public void givenDiscountObject_whenUpdateDiscount_changeDiscountPercentage() {
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
	
//---------------------------------------------------------------------------------------

	@Test
	@DisplayName("JUNIT test for saving discount object")
	public void givenDiscountObject_whenSave_getDiscount() {
		//setup
		DiscountEntity discountEntity5Percentage = new DiscountEntity(Bank.Axis, 5.0);
		//save discount before update
		
		System.out.println(discountEntity5Percentage);
		
		//when-action to test
	 	DiscountEntity discountSaved = discountRepository.save(discountEntity5Percentage);
		
		
		//then verification
		assertThat(discountSaved).isNotNull();
		assertThat(discountSaved.getDiscountPercentage()).isEqualTo(5.0);
	}
	
//---------------------------------------------------------------------------------------
	
	
	@Test
	@DisplayName("JUNIT test to get discount by bankName")
	public void givenDiscountObject_whenFindByBankName_getDiscount() {
		//setup
		DiscountEntity discountEntity5Percentage = new DiscountEntity(Bank.Axis, 5.0);
		DiscountEntity discountSaved = discountRepository.save(discountEntity5Percentage);
		
		//when-action to test
	 	DiscountEntity discountFound = this.discountRepository.getByBankName(Bank.Axis);
		
		
		//then verification
		assertThat(discountFound).isNotNull();
		assertThat(discountFound.getDiscountPercentage()).isEqualTo(5.0);
	}
	
//---------------------------------------------------------------------------------------

	
	@Test
	@DisplayName("JUNIT test to get discount by bankName (negative testing)")
	public void givenDiscountObject_whenFindByWrongBankName_dontGetDiscountObject() {
		//setup
		DiscountEntity discountEntity5Percentage = new DiscountEntity(Bank.Axis, 5.0);
		DiscountEntity discountSaved = discountRepository.save(discountEntity5Percentage);
		
		//when-action to test
	 	DiscountEntity discountFound = this.discountRepository.getByBankName(Bank.Central);
		
		
		//then verification
		assertThat(discountFound).isNull();
	}
	
//---------------------------------------------------------------------------------------


	@Test
	@DisplayName("JUNIT test to delete the discount object by id")
	public void givenDiscountObject_whenDeleteById_discountDeleted() {
		//setup
		DiscountEntity discountEntity5Percentage = new DiscountEntity(Bank.Axis, 5.0);
		DiscountEntity discountSaved = discountRepository.save(discountEntity5Percentage);
		
		//when-action to test
		this.discountRepository.deleteById(discountSaved.getDiscountId());
		Optional<DiscountEntity> discountFound = discountRepository.findById(discountSaved.getDiscountId());
		
		
		//then verification
		System.out.println(discountFound);
		assertThat(discountFound).isEmpty();
	}
	
//---------------------------------------------------------------------------------------

}
