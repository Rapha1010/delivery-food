package com.sage.deliveryfood.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sage.deliveryfood.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
	
	public abstract Optional<UserModel> findByUsername(String username);

}
