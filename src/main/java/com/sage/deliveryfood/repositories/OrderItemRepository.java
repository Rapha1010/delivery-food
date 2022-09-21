package com.sage.deliveryfood.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sage.deliveryfood.models.ClientModel;
import com.sage.deliveryfood.models.OrderItemModel;

public interface OrderItemRepository extends JpaRepository<OrderItemModel, UUID>{
	
	public abstract Optional<OrderItemModel> findByDescription(String description);

}
