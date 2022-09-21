package com.sage.deliveryfood.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sage.deliveryfood.dtos.request.OrderItenDTO;
import com.sage.deliveryfood.exceptionhandler.ClientNotFoundException;
import com.sage.deliveryfood.exceptionhandler.OrderItenNotFoundException;
import com.sage.deliveryfood.models.OrderItemModel;
import com.sage.deliveryfood.repositories.OrderItemRepository;

@Service
public class OrderItenSevice {
	
	private OrderItemRepository orderItemRepository;

	public OrderItenSevice(OrderItemRepository orderItemRepository) {
		this.orderItemRepository = orderItemRepository;
	}
	
	public List<OrderItemModel> findAll() {
		return orderItemRepository.findAll();
	}
	
	public OrderItemModel save(OrderItemModel orderIten) {
		
		orderIten.setUpdateDateTime(LocalDateTime.now(ZoneId.of("UTC")));
		orderIten.setCreationDateTime(LocalDateTime.now(ZoneId.of("UTC")));
		
		return orderItemRepository.save(orderIten);
	}
	
	public OrderItemModel update(UUID id, OrderItenDTO obj) {
		
		OrderItemModel orderIten = findById(id);
		
		System.out.println("1"+orderIten.getId());
		
		BeanUtils.copyProperties(obj, orderIten,"id");
		
		System.out.println("2"+orderIten.getId());
	
		orderIten.setUpdateDateTime(LocalDateTime.now(ZoneId.of("UTC")));
		
		return orderItemRepository.save(orderIten);
	}
	
	public OrderItemModel findById(UUID id) {
		
		Optional<OrderItemModel> orderItenOptional = orderItemRepository.findById(id);
		
		if (!orderItenOptional.isPresent()) {
			return orderItenOptional.orElseThrow(() -> new OrderItenNotFoundException());
		}
			
		return orderItenOptional.get();
		
	}
	
	public void delete(OrderItemModel orderIten) {
		 orderItemRepository.delete(orderIten);
	}

}
