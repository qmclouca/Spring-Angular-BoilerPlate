package com.qmclouca.springangularboilerplate.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class baseEntity {

    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER", updatable = false, nullable = false)
    private Integer id;

    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "data_alteracao")
    private LocalDateTime dataAlteracao;
}
