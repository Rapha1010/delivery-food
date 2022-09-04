package com.sage.deliveryfood.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sage.deliveryfood.models.OrderItenModel;
import com.sage.deliveryfood.repositories.OrderItenRepository;

@Service
public class OrderItenSevice {
	
	private OrderItenRepository orderItenRepository;

	public OrderItenSevice(OrderItenRepository orderItenRepository) {
		this.orderItenRepository = orderItenRepository;
	}
	
	public List<OrderItenModel> findAll() {
		return orderItenRepository.findAll();
	}
	
	public OrderItenModel save(OrderItenModel orderIten) {
		
		orderIten.setUpdateDateTime(LocalDateTime.now(ZoneId.of("UTC")));
		orderIten.setCreationDateTime(LocalDateTime.now(ZoneId.of("UTC")));
		
		return orderItenRepository.save(orderIten);
	}
	

}
