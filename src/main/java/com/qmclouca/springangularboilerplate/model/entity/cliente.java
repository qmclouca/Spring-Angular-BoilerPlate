package com.qmclouca.springangularboilerplate.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class cliente extends baseEntity {

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;
}
