package com.sage.entregacomida.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sage.entregacomida.domain.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>  {

}
