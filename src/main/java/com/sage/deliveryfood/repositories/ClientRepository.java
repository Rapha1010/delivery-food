package com.sage.deliveryfood.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sage.deliveryfood.models.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID>  {
	boolean existsById(Long id);
	
	@Query(value = "SELECT max(c.number) FROM ClientModel c")
	Long maxClientNumber();
}
