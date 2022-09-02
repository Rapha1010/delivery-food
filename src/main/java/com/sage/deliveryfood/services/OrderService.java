package com.sage.deliveryfood.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sage.deliveryfood.enums.StatusType;
import com.sage.deliveryfood.exceptionhandler.ClientNotFoundException;
import com.sage.deliveryfood.exceptionhandler.OrderNotFoundException;
import com.sage.deliveryfood.models.ClientModel;
import com.sage.deliveryfood.models.OrderModel;
import com.sage.deliveryfood.repositories.ClientRepository;
import com.sage.deliveryfood.repositories.OrderRepository;

@Service
public class OrderService {
	
	public OrderRepository orderRepository;
	public ClientRepository clientRepository;
	
	@Autowired
	public OrderService(OrderRepository orderRepository, ClientRepository clientRepository) {
		this.orderRepository = orderRepository;
		this.clientRepository = clientRepository;
	}
	
	public Object save(OrderModel obj) {
		
		obj.setCreationDateTime(LocalDateTime.now(ZoneId.of("UTC")));
		Optional<ClientModel> clienteOptional  = clientRepository.findById(obj.getClient().getId());
		
		if (!clienteOptional.isPresent())
			return clienteOptional.orElseThrow(() -> new ClientNotFoundException());
		
		return orderRepository.save(obj);
	}

	public List<OrderModel> findAll() {
		return orderRepository.findAll();
	}
	
	public void delete(OrderModel obj) {
		orderRepository.delete(obj);
	}

	public OrderModel findById(UUID id) {
		
		Optional<OrderModel> orderModelOptional = orderRepository.findById(id);
		
		if(!orderModelOptional.isPresent()) {
			return orderModelOptional.orElseThrow(() -> new OrderNotFoundException());
		}
		
		return orderModelOptional.get();
	}

	public void cancel(OrderModel order) {
		order.setUpdateDateTime(LocalDateTime.now(ZoneId.of("UTC")));
		order.setStatus(StatusType.CANCELED);
		orderRepository.save(order);
	}

}
