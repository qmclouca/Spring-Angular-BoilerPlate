package com.qmclouca.springangularboilerplate.model.repository;

import com.qmclouca.springangularboilerplate.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

}
