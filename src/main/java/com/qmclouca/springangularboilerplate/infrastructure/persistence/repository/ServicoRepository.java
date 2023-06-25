package com.qmclouca.springangularboilerplate.infrastructure.persistence.repository;

import com.qmclouca.springangularboilerplate.domain.service.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer>{
}
