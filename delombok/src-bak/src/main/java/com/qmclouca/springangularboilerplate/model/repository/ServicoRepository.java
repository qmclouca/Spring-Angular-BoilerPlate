package com.qmclouca.springangularboilerplate.entities.repository;

import com.qmclouca.springangularboilerplate.entities.services.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer>{
}
