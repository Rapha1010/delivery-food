package com.sage.entregacomida.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sage.entregacomida.modals.Cliente;
import com.sage.entregacomida.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	public ClienteRepository clienteRepository; 
	
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable);
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
