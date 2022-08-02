package com.sage.entregacomida.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sage.entregacomida.domain.entities.Cliente;
import com.sage.entregacomida.repositories.ClienteRepository;

@Configuration
public class ApplicationConfig implements CommandLineRunner  {
	
	@Autowired
	public ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Cliente cliente1 = new Cliente(1L,"Joao da silva", "joao.silva@ibm.com",994618524L);
		Cliente cliente2 = new Cliente(2L,"ana maria", "ana.maria@ibm.com",994618522L);
		Cliente cliente3 = new Cliente(3L,"thiago ventura", "thiago.ventura@ibm.com",994618523L);
		
		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
		
	}

}
