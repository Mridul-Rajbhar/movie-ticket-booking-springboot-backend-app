package com.training.project.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

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
	
//----------------------------------------------------------------------------------------------------
	
	// JUNIT test for get order by id operations
		@Test
		@DisplayName("JUNIT test for getting Order by ID operation")
		public void givenOrderObject_whenFindByID_thenReturnOrderObject() {
			
			//given - setup
			ContactAddressEntity contactAddressEntity = new ContactAddressEntity("8928015475","mrodil@gmail.com");
			UsersEntity user = new  UsersEntity(contactAddressEntity,"Mridul","Rajbhar","Male",LocalDate.of(2023, 12, 21), "1231");
			MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(),"UA",LocalDate.of(2022, 2, 1),
					"desctription", "url");
			DiscountEntity discountEntity = new DiscountEntity(Bank.Axis, 32.33);
			BookingEntity bookingEntity = new BookingEntity(movieEntity, MovieLanguage.English, 
					"2d", LocalDate.of(2023,2, 2), LocalTime.now());
			OrderEntity order = new OrderEntity(bookingEntity, discountEntity, CardType.Credit, Bank.Axis,570, user);
			this.orderRepository.save(order);

			//when action
			OrderEntity orderEntity = this.orderRepository.findById(order.getOrderId()).get();
			
			//then
			assertThat(orderEntity).isNotNull();
		}
// -------------------------------------------------------------------------------------------

		// JUNIT test for get order by id operations when wrong id passed
		@Test
		@DisplayName("JUNIT test for getting Order by ID when orderId is not passed (negative scenario) operation")
		public void givenOrderObject_whenFindByIDIsNotPresent_thenReturnNull() {

			// given - precondition or setup
			ContactAddressEntity contactAddressEntity = new ContactAddressEntity("8928015475","mrodil@gmail.com");
			UsersEntity user = new  UsersEntity(contactAddressEntity,"Mridul","Rajbhar","Male",LocalDate.of(2023, 12, 21), "1231");
			MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(),"UA",LocalDate.of(2022, 2, 1),
					"desctription", "url");
			DiscountEntity discountEntity = new DiscountEntity(Bank.Axis, 32.33);
			BookingEntity bookingEntity = new BookingEntity(movieEntity, MovieLanguage.English, 
					"2d", LocalDate.of(2023,2, 2), LocalTime.now());
			OrderEntity order = new OrderEntity(bookingEntity, discountEntity, CardType.Credit, Bank.Axis,570, user);
			this.orderRepository.save(order);

			
			// when - action or behavior that we are going to test
			Optional<OrderEntity> orderOptional = orderRepository.findById(222);

			// then - verify the output
			assertThat(orderOptional).isEmpty();
		}

// -------------------------------------------------------------------------------------------------

		@DisplayName("JUNIT test for deleting order object")
		@Test
		public void givenOrderObject_whenDelete_thenRemoveOrder() {

			// given - precondition or setup
			ContactAddressEntity contactAddressEntity = new ContactAddressEntity("8928015475","mrodil@gmail.com");
			UsersEntity user = new  UsersEntity(contactAddressEntity,"Mridul","Rajbhar","Male",LocalDate.of(2023, 12, 21), "1231");
			MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(),"UA",LocalDate.of(2022, 2, 1),
					"desctription", "url");
			DiscountEntity discountEntity = new DiscountEntity(Bank.Axis, 32.33);
			BookingEntity bookingEntity = new BookingEntity(movieEntity, MovieLanguage.English, 
					"2d", LocalDate.of(2023,2, 2), LocalTime.now());
			OrderEntity order = new OrderEntity(bookingEntity, discountEntity, CardType.Credit, Bank.Axis,570, user);
			this.orderRepository.save(order);

			// when
			orderRepository.deleteById(order.getOrderId());
	         
			Optional<OrderEntity> orderOptional =   orderRepository.findById(order.getOrderId());
			
			// then 
			assertThat(orderOptional).isEmpty();
			
		}
		
//---------------------------------------------------------------------------------------------------------
		// update

		@DisplayName("Junit test for update operation by updating discount applied ")
		@Test
		public void givenOrderObject_whenUpdate_thenReturnUpdatedOrder() {

			// given - precondition or setup
			ContactAddressEntity contactAddressEntity = new ContactAddressEntity("8928015475","mrodil@gmail.com");
			UsersEntity user = new  UsersEntity(contactAddressEntity,"Mridul","Rajbhar","Male",LocalDate.of(2023, 12, 21), "1231");
			MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(),"UA",LocalDate.of(2022, 2, 1),
					"desctription", "url");
			DiscountEntity discountEntity = new DiscountEntity(Bank.Axis, 32.33);
			BookingEntity bookingEntity = new BookingEntity(movieEntity, MovieLanguage.English, 
					"2d", LocalDate.of(2023,2, 2), LocalTime.now());
			OrderEntity order = new OrderEntity(bookingEntity, discountEntity, CardType.Credit, Bank.Axis,570, user);
			this.orderRepository.save(order);
			DiscountEntity discountEntity2  = new DiscountEntity(Bank.Central, 22);
			
			// when
			
			OrderEntity savedOrder = orderRepository.findById(order.getOrderId()).get();
			savedOrder.setDiscount(discountEntity2);
			OrderEntity updatedOrder = orderRepository.save(savedOrder);

			// then
			assertThat(updatedOrder.getDiscount()).isEqualTo(discountEntity2);
		}
		//---------------------------------------------------------------------------------------------------------

}
