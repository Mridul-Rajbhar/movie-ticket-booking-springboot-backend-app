package com.training.project.services;

import java.util.ArrayList;
import java.util.List;
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
import com.training.project.repositories.SeatsRepository;
import com.training.project.repositories.UsersRepository;
import com.training.project.repositories.entities.BookingEntity;
import com.training.project.repositories.entities.ContactAddressEntity;
import com.training.project.repositories.entities.DiscountEntity;
import com.training.project.repositories.entities.MovieEntity;
import com.training.project.repositories.entities.OrderEntity;
import com.training.project.repositories.entities.SeatsEntity;
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
	private DiscountRepository discountRepository;
	
	@Autowired
	private SeatsRepository seatsRepository;
	
	private ModelMapper mapper;
	private static Logger logger = LoggerFactory.getLogger(OrderEntity.class);
	
	public OrderService(){
		logger.info("order service constructor created");
		mapper = new ModelMapper();
	}
	
	
	//create orders
	public OrderDto saveOrder(OrderDto orderDto, Integer userId, String movieName) {
		System.out.println(orderDto);
		MovieEntity movieEntity = this.movieRepository.getByMovieName(movieName);
		UsersEntity userEntity = this.userRepository.findById(userId).get();
		DiscountEntity discountEntity = this.discountRepository.getByBankName(orderDto.getBank());
		
		System.out.println("Movie: " + movieEntity);
		System.out.println("USer Entity" + userEntity);
		System.out.println("Discount Entity" + discountEntity);
		logger.info("order dependencies fullfilled");
		
		
		OrderEntity orderEntity = mapper.map(orderDto, OrderEntity.class);
		orderEntity.getBooking().setMovie(movieEntity);
		orderEntity.setUser(userEntity);
		orderEntity.setDiscount(discountEntity);
		OrderEntity returnedOrderEntity = orderRepository.save(orderEntity);
		
		List<SeatsEntity> seatToBooked = orderEntity.getBooking().getSeats();
		List<SeatsEntity> returnSeatWithId = new ArrayList<>(); 
		
		System.out.println("before seats booked: " + orderEntity);
		for(SeatsEntity seatsEntity: seatToBooked) {
			seatsEntity.setBooking(orderEntity.getBooking());
			returnSeatWithId.add(this.seatsRepository.save(seatsEntity));
		}
		orderEntity.getBooking().setSeats(returnSeatWithId);
		
		System.out.println(orderEntity);
		
		OrderDto returnOrderDto = mapper.map(returnedOrderEntity, OrderDto.class);
		return returnOrderDto;
//		return orderDto;
	}
	
		//get order by id
		public OrderDto findOrderById(Integer orderId) {
			Optional<OrderEntity> checkOrderEntity = this.orderRepository.findById(orderId);
			OrderDto orderDto = null;
			if(checkOrderEntity.isPresent()) {
				OrderEntity returnedOrderEntity =  checkOrderEntity.get();
				orderDto = mapper.map(returnedOrderEntity, OrderDto.class);
			}	
			return orderDto;
		}
		
		//get all orders
		public List<OrderDto> getAllOrders(){
			Iterable<OrderEntity> allOrdersEntity = this.orderRepository.findAll();
			List<OrderDto> allOrdersDtos = new ArrayList<OrderDto>();
			for(OrderEntity orderEntity: allOrdersEntity) {
				OrderDto orderDto = mapper.map(orderEntity, OrderDto.class);
				allOrdersDtos.add(orderDto);
			}
			return allOrdersDtos;
		}
	
	
}
