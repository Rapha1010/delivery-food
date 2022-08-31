package com.sage.deliveryfood.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sage.deliveryfood.dtos.request.ClientDTO;
import com.sage.deliveryfood.models.ClientModel;
import com.sage.deliveryfood.services.ClientService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientController {
	
	@Autowired
	public ClientService clientService;
	
	@GetMapping
	public ResponseEntity<Page<ClientModel>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findById(@PathVariable UUID id) {
		ClientModel client = clientService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(client);
	}
	
	@PostMapping
	public ResponseEntity<ClientModel> save(@RequestBody @Valid ClientDTO obj) {
		ClientModel client = new ClientModel();
		BeanUtils.copyProperties(obj, client);
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientModel> update(@PathVariable UUID id, @RequestBody @Valid ClientDTO obj) {
		ClientModel client = clientService.findById(id);
		BeanUtils.copyProperties(obj, client,"id");
		return ResponseEntity.status(HttpStatus.OK).body(clientService.save(client));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable UUID id) {
		ClientModel client = clientService.findById(id);
		clientService.delete(client);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
