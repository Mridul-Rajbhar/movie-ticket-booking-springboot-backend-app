package com.training.project.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.training.project.dto.Bank;
import com.training.project.dto.BookingDto;
import com.training.project.dto.CardType;
import com.training.project.dto.ContactAddressDto;
import com.training.project.dto.DiscountDto;
import com.training.project.dto.MovieDto;
import com.training.project.dto.MovieGenre;
import com.training.project.dto.MovieLanguage;
import com.training.project.dto.OrderDto;
import com.training.project.dto.UsersDto;
import com.training.project.repositories.BookingRepository;
import com.training.project.repositories.DiscountRepository;
import com.training.project.repositories.MovieRepository;
import com.training.project.repositories.OrderRepository;
import com.training.project.repositories.UsersRepository;
import com.training.project.repositories.entities.BookingEntity;
import com.training.project.repositories.entities.ContactAddressEntity;
import com.training.project.repositories.entities.DiscountEntity;
import com.training.project.repositories.entities.MovieEntity;
import com.training.project.repositories.entities.OrderEntity;
import com.training.project.repositories.entities.UsersEntity;

@ExtendWith(MockitoExtension.class)
public class OrderServiceUnitTests {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Mock
	private MovieRepository movieRepository;
	
	@Mock
	private UsersRepository userRepository;
	
	@Mock
	private OrderRepository orderRepository;
	
	@Mock
	private DiscountRepository discountRepository;
	
	@Mock
	private BookingRepository bookingRepository;
	
	@InjectMocks
	private OrderService orderService;
	

//---------------------------------------------------------------------------------------------	
		@DisplayName("Junit test for get all orders (positive) scenario")
		@Test
		public void givenOrderList_whenGetAllOrders_thenGetOrdresList() {

			// given - precondition or setup
			ContactAddressEntity contactAddressEntity = new ContactAddressEntity("8928015475","mrodil@gmail.com");
			UsersEntity user = new  UsersEntity(contactAddressEntity,"Mridul","Rajbhar","Male",LocalDate.of(2023, 12, 21), "1231");
			MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(),"UA",LocalDate.of(2022, 2, 1),
					"desctription", "url");
			DiscountEntity discountEntity = new DiscountEntity(Bank.Axis, 32.33);
			DiscountEntity discountEntity2 = new DiscountEntity(Bank.Central, 32.33);
			BookingEntity bookingEntity = new BookingEntity(movieEntity, MovieLanguage.English, 
					"2d", LocalDate.of(2023,2, 2), LocalTime.now());
			
			OrderEntity order1 = new OrderEntity(bookingEntity, discountEntity, CardType.Debit, Bank.Axis,570, user);
			OrderEntity order2 = new OrderEntity(bookingEntity, discountEntity2, CardType.Credit, Bank.Central,220, user);
			this.orderRepository.save(order1);
			this.orderRepository.save(order2);
			
			
			// given
			BDDMockito.given(orderRepository.findAll()).willReturn(List.of(order1, order2));

			// when
			List<OrderDto> orders = orderService.getAllOrders();

			// then
			assertThat(orders).isNotNull();
			assertThat(orders.size()).isEqualTo(2);
		}
//---------------------------------------------------------------------------------------------

		@DisplayName("Junit test for get all orders (negative) scenario")
		@Test
		public void givenEmptyOrderList_whenGetAllOrders_thenGetEmptyOrdresList() {

			// given
			BDDMockito.given(orderRepository.findAll()).willReturn(Collections.emptyList());

			// when
			List<OrderDto> orders = orderService.getAllOrders();

			// then
			assertThat(orders).isEmpty();
			assertThat(orders.size()).isEqualTo(0);
		}

// ---------------------------------------------------------------------------------------------

		@DisplayName("Junit test for saving orders")
		@Test
		public void givenOrders_whenSaved_thenNewSavedOrderObject() {
			//given
			ContactAddressEntity contactAddressEntity = new ContactAddressEntity("8928015475","mrodil@gmail.com");
			UsersEntity user = new  UsersEntity(contactAddressEntity,"Mridul","Rajbhar","Male",LocalDate.of(2023, 12, 21), "1231");
			
			MovieEntity movieEntity = new MovieEntity(MovieGenre.Action, "Pathaan", LocalTime.now(),"UA",LocalDate.of(2022, 2, 1),
					"desctription", "url");
			BookingEntity bookingEntity = new BookingEntity(movieEntity, MovieLanguage.English, 
					"2d", LocalDate.of(2023,2, 2), LocalTime.now());
			
			DiscountEntity discountEntity = new DiscountEntity(Bank.Axis, 32.33);
			OrderEntity order1 = new OrderEntity(bookingEntity, discountEntity, CardType.Debit, Bank.Axis,570, user);
			
			BDDMockito.given(userRepository.save(user)).willReturn(user);
			BDDMockito.given(movieRepository.save(movieEntity)).willReturn(movieEntity);
			BDDMockito.given(bookingRepository.save(bookingEntity)).willReturn(bookingEntity);
			
			
			//when
			OrderDto savedOrderDto = this.orderService.saveOrder(modelMapper.map(order1,OrderDto.class), 1,  "Pathan");
			
			
			//then 
			assertThat(savedOrderDto).isNotNull();
			
		}

// ---------------------------------------------------------------------------------------------

		
}
