package com.training.project.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.project.dto.Bank;
import com.training.project.dto.OrderDto;
import com.training.project.repositories.BookingRepository;
import com.training.project.repositories.ContactAddressRepository;
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

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private ContactAddressRepository contactAddressRepository;
	
	@Autowired
	private DiscountRepository discountRepository;
	
	private ModelMapper mapper;
	private static Logger logger = LoggerFactory.getLogger(OrderEntity.class);
	
	public OrderService(){
		logger.info("order service constructor created");
		mapper = new ModelMapper();
	}
	
	public OrderDto saveOrder(OrderDto orderDto, String userEmail, String movieName) {
		
		MovieEntity movieToBook = this.movieRepository.getByMovieName(movieName);
		ContactAddressEntity contactAddressEntity = this.contactAddressRepository.getByEmail(userEmail);
		UsersEntity usersEntity = this.userRepository.getByContactAddress(contactAddressEntity);
		//System.out.println(orderDto.getBank().);
		DiscountEntity discountEntity = this.discountRepository.getByBankName(orderDto.getBank());
		logger.info("oreder dependencies fullfilled");
		OrderEntity orderEntity = mapper.map(orderDto, OrderEntity.class);
		orderEntity.getBooking().setMovie(movieToBook);
		orderEntity.setUser(usersEntity);
		orderEntity.setDiscount(discountEntity);
		
		System.out.println(orderEntity);
		
		
		OrderEntity returnedOrderEntity = orderRepository.save(orderEntity);
		OrderDto returnOrderDto = mapper.map(returnedOrderEntity, OrderDto.class);
		return returnOrderDto;
	}
	
		//get order
		public OrderDto findOrderById(Integer orderId) {
			Optional<OrderEntity> checkOrderEntity = this.orderRepository.findById(orderId);
			OrderDto orderDto = null;
			if(checkOrderEntity.isPresent()) {
				OrderEntity returnedOrderEntity =  checkOrderEntity.get();
				orderDto = mapper.map(returnedOrderEntity, OrderDto.class);
			}	
			return orderDto;
		}
	
	
}
