package com.qmclouca.springangularboilerplate.domain.service;

import com.qmclouca.springangularboilerplate.domain.model.entities.Client;
import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Client client;

    @Column
    private BigDecimal valor;
}
