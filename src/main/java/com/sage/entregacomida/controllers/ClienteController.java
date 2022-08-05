package com.sage.entregacomida.controllers;

import java.util.Optional;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sage.entregacomida.dtos.ClienteDTO;
import com.sage.entregacomida.modals.Cliente;
import com.sage.entregacomida.services.ClienteService;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {
	
	@Autowired
	public ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<Page<Cliente>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.findById(id);
		if (!cliente.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente nao encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
	}
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteDTO obj) {
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(obj, cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
	}
	
	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody @Valid ClienteDTO obj) {
		Optional<Cliente> clienteOptional = clienteService.findById(obj.getId());
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(obj, cliente);
		cliente.setId(clienteOptional.get().getId());
	
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		Optional<Cliente> clienteOptional = clienteService.findById(id);
		if (!clienteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente nao encontrado");
		}
		clienteService.delete(clienteOptional.get());
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
