package com.sage.deliveryfood.services;


import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sage.deliveryfood.exceptionhandler.ClientNotFoundException;
import com.sage.deliveryfood.modals.Client;
import com.sage.deliveryfood.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	public ClientRepository clientRepository; 
	
	public Page<Client> findAll(Pageable pageable) {
		return clientRepository.findAll(pageable);
	}

	public Client findById(UUID id) {
		Optional<Client> clienteOptional = clientRepository.findById(id);
		return clienteOptional.orElseThrow(() -> new ClientNotFoundException());
	}

	public Client save(Client client) {
		Long clienteNumber = clientRepository.maxClientNumber();
		if (clienteNumber == null) clienteNumber = 1L; else clienteNumber++;
		
		client.setNumber(clienteNumber);
		return clientRepository.save(client);
	}

	public void delete(Client client) {
		clientRepository.delete(client);
	}

}
