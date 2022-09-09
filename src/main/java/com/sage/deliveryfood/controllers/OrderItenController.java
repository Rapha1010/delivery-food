package com.sage.deliveryfood.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sage.deliveryfood.dtos.request.OrderItenDTO;
import com.sage.deliveryfood.models.OrderItenModel;
import com.sage.deliveryfood.services.OrderItenSevice;

@RestController
@RequestMapping(value = "/api/itens")
@CrossOrigin(origins = {"http://127.0.0.1:5500"}, maxAge = 3600)
public class OrderItenController {
	
	@Autowired
	private OrderItenSevice orderItenService;
	
	@GetMapping
	public List<OrderItenModel> findAll() {
		return orderItenService.findAll();
	}
	
	@PostMapping
	public OrderItenModel save(@RequestBody @Valid OrderItenModel obj) {
		return orderItenService.save(obj);
	}
	
	@PutMapping(value = "/{id}")
	public OrderItenModel update(@PathVariable UUID id, @RequestBody @Valid OrderItenDTO obj) {
		return orderItenService.update(id, obj);
	}
	
	@GetMapping(value = "/{id}")
	public Object findById(@PathVariable UUID id) {
		return orderItenService.findById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public Object delete(@PathVariable UUID id) {
		orderItenService.delete(orderItenService.findById(id));
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
