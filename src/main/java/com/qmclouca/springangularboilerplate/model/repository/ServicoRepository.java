package com.qmclouca.springangularboilerplate.model.repository;

import com.qmclouca.springangularboilerplate.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicoRepository extends JpaRepository<Servico, UUID>{
}
