package com.qmclouca.springangularboilerplate.model.repository;

import com.qmclouca.springangularboilerplate.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByNome(String nome);
    Cliente findById(int id);
}
