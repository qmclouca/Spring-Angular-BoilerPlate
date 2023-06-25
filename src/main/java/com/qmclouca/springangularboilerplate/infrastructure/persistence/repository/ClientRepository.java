package com.qmclouca.springangularboilerplate.infrastructure.persistence.repository;

import com.qmclouca.springangularboilerplate.domain.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, ClientRepository> {
    Client findByNome(String nome);
    Client findById(int id);
    Client deleteById(int id);
}
