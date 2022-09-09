package com.sage.deliveryfood.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfigSecurity {
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic()
		.and().cors().and().authorizeHttpRequests()
		.antMatchers(HttpMethod.GET).hasAnyRole("ADMIN","USER")
		.antMatchers(HttpMethod.POST).hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT).hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
		.anyRequest().authenticated().and().csrf().disable();
		
		return httpSecurity.build();
	}
	
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
