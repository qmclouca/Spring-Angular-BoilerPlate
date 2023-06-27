package com.qmclouca.springangularboilerplate.infrastructure.persistence.repository;

import com.qmclouca.springangularboilerplate.domain.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByNome(String nome);

    Client findByName(String nome);
}
