package com.sage.deliveryfood.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sage.deliveryfood.modals.Client;
import com.sage.deliveryfood.services.ClientService;
@Configuration
public class ApplicationConfig implements CommandLineRunner  {
	
	@Autowired
	public ClientService clientService;

	@Override
	public void run(String... args) throws Exception {
		
//		Client cliente1 = new Client(1L,"Joao da Silva", "joao.silva@ibm.com",994618524L);
//		Client cliente2 = new Client(2L,"Ana Maria", "ana.maria@ibm.com",994618522L);
//		Client cliente3 = new Client(3L,"Thiago Alves", "thiago.alves@ibm.com",994618523L);
//		Client cliente4 = new Client(4L,"Julia Souza", "julia.souza@ibm.com",994618523L);
//		Client cliente5 = new Client(5L,"Igor Motta", "igor.motta@ibm.com",994618524L);
//		Client cliente6 = new Client(6L,"Teo Nunes", "teo.nunes@ibm.com",994618522L);
//		Client cliente7 = new Client(7L,"Leonardo Martins", "leonardo.martins@ibm.com",994618523L);
//		Client cliente8 = new Client(8L,"Paula Bordalo", "paula.bordalo@ibm.com",994618523L);
//
//		clientRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3, cliente4, cliente5, cliente6, cliente7, cliente8));
		
		Client cliente1 = new Client("Joao da Silva", "joao.silva@ibm.com",994618524L);
		Client cliente2 = new Client("Ana Maria", "ana.maria@ibm.com",994618522L);
		Client cliente3 = new Client("Thiago Alves", "thiago.alves@ibm.com",994618523L);
		Client cliente4 = new Client("Julia Souza", "julia.souza@ibm.com",994618523L);
		Client cliente5 = new Client("Igor Motta", "igor.motta@ibm.com",994618524L);
		Client cliente6 = new Client("Teo Nunes", "teo.nunes@ibm.com",994618522L);
		Client cliente7 = new Client("Leonardo Martins", "leonardo.martins@ibm.com",994618523L);
		Client cliente8 = new Client("Paula Bordalo", "paula.bordalo@ibm.com",994618523L);		
		
		clientService.save(cliente1);
		clientService.save(cliente2);
		clientService.save(cliente3);
		clientService.save(cliente4);
		clientService.save(cliente5);
		clientService.save(cliente6);
		clientService.save(cliente7);
		clientService.save(cliente8);
		
	}

}
