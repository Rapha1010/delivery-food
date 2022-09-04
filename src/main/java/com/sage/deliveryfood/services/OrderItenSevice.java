package com.sage.deliveryfood.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sage.deliveryfood.exceptionhandler.ClientNotFoundException;
import com.sage.deliveryfood.exceptionhandler.OrderItenNotFoundException;
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
	
	public OrderItenModel update(UUID id, OrderItenModel obj) {
		
		OrderItenModel orderIten = findById(id);
		
		BeanUtils.copyProperties(obj, orderIten, "id");
		
		orderIten.setUpdateDateTime(LocalDateTime.now(ZoneId.of("UTC")));
		
		return orderItenRepository.save(orderIten);
	}
	
	public OrderItenModel findById(UUID id) {
		
		Optional<OrderItenModel> orderItenOptional = orderItenRepository.findById(id);
		
		if (!orderItenOptional.isPresent()) {
			return orderItenOptional.orElseThrow(() -> new OrderItenNotFoundException());
		}
			
		return orderItenOptional.get();
		
	}
	
	public void delete(OrderItenModel orderIten) {
		 orderItenRepository.delete(orderIten);
	}

}
