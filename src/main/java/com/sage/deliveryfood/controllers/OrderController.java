package com.sage.deliveryfood.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sage.deliveryfood.models.OrderModel;
import com.sage.deliveryfood.services.OrderService;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {
	
	public OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid OrderModel obj) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<OrderModel>> findAll() {
		return ResponseEntity.ok().body(orderService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderModel> findById(@PathVariable UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> cancel(@PathVariable UUID id) {
		
		OrderModel orderModel = orderService.findById(id);
		orderService.cancel(orderModel);
		return ResponseEntity.status(HttpStatus.OK).body("order canceled success");
	}

}
