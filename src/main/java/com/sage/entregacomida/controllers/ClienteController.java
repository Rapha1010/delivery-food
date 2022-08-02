package com.sage.entregacomida.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.sage.entregacomida.domain.entities.Cliente;
import com.sage.entregacomida.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {
	
	@Autowired
	public ClienteRepository clienteRepository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = clienteRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return ResponseEntity.ok().body(cliente.get());
	}
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente obj) {
		Cliente cliente = clienteRepository.save(obj);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> update(@RequestBody Cliente obj) {

		Cliente cliente = clienteRepository.getReferenceById(obj.getId());
		updataData(obj, cliente);
		Cliente clienteSave = clienteRepository.save(cliente);
		
		return ResponseEntity.ok().body(clienteSave);
	}
	
	public void updataData(Cliente obj, Cliente cliente) {
		cliente.setNome(obj.getNome());
		cliente.setEmail(obj.getEmail());
		cliente.setTelefone(obj.getTelefone());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id) {
		Cliente cliente = clienteRepository.getReferenceById(id);
		clienteRepository.delete(cliente);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
