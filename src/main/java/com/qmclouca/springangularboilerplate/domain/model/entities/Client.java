package com.qmclouca.springangularboilerplate.domain.model.entities;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER", updatable = false, nullable = false)
    private Integer id;

    @Column(updatable = false, nullable = false, name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDateTime.now());
    }
}
