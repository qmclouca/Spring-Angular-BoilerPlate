package com.qmclouca.springangularboilerplate.entities.repository;

import com.qmclouca.springangularboilerplate.entities.services.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByNome(String nome);
}
