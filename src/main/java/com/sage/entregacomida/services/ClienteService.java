package com.sage.entregacomida.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sage.entregacomida.modals.Cliente;
import com.sage.entregacomida.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	public ClienteRepository clienteRepository; 
	
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void delete(Cliente cliente) {
		clienteRepository.delete(cliente);
	}

}
