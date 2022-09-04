package com.sage.deliveryfood.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sage.deliveryfood.models.OrderItenModel;

public interface OrderItenRepository extends JpaRepository<OrderItenModel, UUID>{

}
