package com.sage.entregacomida.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sage.entregacomida.modals.Cliente;
import com.sage.entregacomida.repositories.ClienteRepository;

@Configuration
public class ApplicationConfig implements CommandLineRunner  {
	
	@Autowired
	public ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Cliente cliente1 = new Cliente(1L,"Joao da Silva", "joao.silva@ibm.com",994618524L);
		Cliente cliente2 = new Cliente(2L,"Ana Maria", "ana.maria@ibm.com",994618522L);
		Cliente cliente3 = new Cliente(3L,"Thiago Alves", "thiago.alves@ibm.com",994618523L);
		Cliente cliente4 = new Cliente(4L,"Julia Souza", "julia.souza@ibm.com",994618523L);
		Cliente cliente5 = new Cliente(5L,"Igor Motta", "igor.motta@ibm.com",994618524L);
		Cliente cliente6 = new Cliente(6L,"Teo Nunes", "teo.nunes@ibm.com",994618522L);
		Cliente cliente7 = new Cliente(7L,"Leonardo Martins", "leonardo.martins@ibm.com",994618523L);
		Cliente cliente8 = new Cliente(8L,"Paula Bordalo", "paula.bordalo@ibm.com",994618523L);

		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3, cliente4, cliente5, cliente6, cliente7, cliente8));
		
	}

}
