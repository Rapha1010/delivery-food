package com.sage.entregacomida.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sage.entregacomida.modals.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {
	boolean existsById(Long id);
}
