package com.training.project.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.training.project.dto.Bank;
import com.training.project.dto.CardType;
import com.training.project.dto.MovieGenre;
import com.training.project.dto.MovieLanguage;
import com.training.project.repositories.entities.BookingEntity;
import com.training.project.repositories.entities.ContactAddressEntity;
import com.training.project.repositories.entities.DiscountEntity;
import com.training.project.repositories.entities.MovieEntity;
import com.training.project.repositories.entities.OrderEntity;
import com.training.project.repositories.entities.UsersEntity;

@ActiveProfiles("test")
@DataJpaTest
public class OrderRepositoryTests {
	@Autowired
	private OrderRepository orderRepository;


	// JUNIT test case for save order operation
	@DisplayName("JUNIT Test for save order operation")
	@Test
	public void giveOrderObject_whenSave_thenReturnSavedOrder() {

		// given - precondition or setup
		ContactAddressEntity contactAddressEntity = new ContactAddressEntity("8928015475","mrodil@gmail.com");
		UsersEntity user = new  UsersEntity(contactAddressEntity,"Mridul","Rajbhar","Male",LocalDate.of(2023, 12, 21), "1231");
		MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(),"UA",LocalDate.of(2022, 2, 1),
				"desctription", "url");
		DiscountEntity discountEntity = new DiscountEntity(Bank.Axis, 32.33);
		BookingEntity bookingEntity = new BookingEntity(movieEntity, MovieLanguage.English, 
				"2d", LocalDate.of(2023,2, 2), LocalTime.now());
		OrderEntity order = new OrderEntity(bookingEntity, discountEntity, CardType.Credit, Bank.Axis,570, user);
		

		// when - action or the behaviour that we are going to test
		OrderEntity newSavedOrder = orderRepository.save(order);
		System.out.println("order saved - " + newSavedOrder);

		// then - verify the output
		assertThat(newSavedOrder).isNotNull();
		assertThat(newSavedOrder.getOrderId()).isGreaterThan(0);
	}
}
