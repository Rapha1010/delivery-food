package com.sage.deliveryfood.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sage.deliveryfood.models.OrderItenModel;
import com.sage.deliveryfood.services.OrderItenSevice;

@RestController
@RequestMapping(value = "/api/itens")
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

}
