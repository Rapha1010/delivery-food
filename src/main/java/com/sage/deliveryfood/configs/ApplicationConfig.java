package com.sage.deliveryfood.configs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sage.deliveryfood.configs.security.ConfigSecurity;
import com.sage.deliveryfood.enums.RoleName;
import com.sage.deliveryfood.enums.StatusType;
import com.sage.deliveryfood.models.ClientModel;
import com.sage.deliveryfood.models.OrderModel;
import com.sage.deliveryfood.models.RoleModel;
import com.sage.deliveryfood.models.UserModel;
import com.sage.deliveryfood.repositories.OrderRepository;
import com.sage.deliveryfood.repositories.RoleRepository;
import com.sage.deliveryfood.repositories.UserRepository;
import com.sage.deliveryfood.services.ClientService;
import com.sage.deliveryfood.services.UserServiceImpl;
@Configuration
public class ApplicationConfig implements CommandLineRunner, WebMvcConfigurer  {
	
	@Autowired
	public ClientService clientService;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public RoleRepository roleRepository;
	
	@Autowired
	public OrderRepository orderRepository;
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        	.allowCredentials(true)
            .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

	@Override
	public void run(String... args) throws Exception {
		
		RoleModel role1 = new RoleModel(RoleName.ROLE_ADMIN);
		RoleModel role2 = new RoleModel(RoleName.ROLE_USER);
		
		role1 = roleRepository.save(role1);
		role2 = roleRepository.save(role2);
		
		List<RoleModel> roleList = new ArrayList<>();
		roleList.add(role1);
		roleList.add(role2);
		
		UserModel user1 = new UserModel("raphael", ConfigSecurity.passwordEncoder().encode("123456"), roleList);
		
		// userRepository.save(user1);
		
		
		ClientModel cliente1 = new ClientModel("Joao da Silva", "joao.silva@ibm.com",994618524L);
		ClientModel cliente2 = new ClientModel("Ana Maria", "ana.maria@ibm.com",994618522L);
		ClientModel cliente3 = new ClientModel("Thiago Alves", "thiago.alves@ibm.com",994618523L);
		ClientModel cliente4 = new ClientModel("Julia Souza", "julia.souza@ibm.com",994618523L);
		ClientModel cliente5 = new ClientModel("Igor Motta", "igor.motta@ibm.com",994618524L);
		ClientModel cliente6 = new ClientModel("Teo Nunes", "teo.nunes@ibm.com",994618522L);
		ClientModel cliente7 = new ClientModel("Leonardo Martins", "leonardo.martins@ibm.com",994618523L);
		ClientModel cliente8 = new ClientModel("Paula Bordalo", "paula.bordalo@ibm.com",994618523L);	
		
//		public OrderModel(@NotBlank String address, @NotNull Integer estimatedTimeInMin, LocalDateTime dateTime,
//				@NotNull StatusType status, ClientModel client) {
		
		
		
		
		clientService.save(cliente1);
		clientService.save(cliente2);
		clientService.save(cliente3);
		clientService.save(cliente4);
		clientService.save(cliente5);
		clientService.save(cliente6);
		clientService.save(cliente7);
		clientService.save(cliente8);
		
		
OrderModel order1 = new OrderModel("rua josé higino, 76",40, LocalDateTime.now(), LocalDateTime.now(),StatusType.PROCESSING, cliente1);
		
		orderRepository.save(order1);
		
	}
	

}
