package com.sage.deliveryfood.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sage.deliveryfood.models.UserModel;
import com.sage.deliveryfood.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserModel user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
		return new User(user.getUsername(),user.getPassword(),true,true,true,true, user.getAuthorities());
	}

}
