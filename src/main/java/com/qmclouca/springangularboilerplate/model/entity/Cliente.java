package com.qmclouca.springangularboilerplate.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Cliente extends baseEntity {

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    public static void main(String[] args) {
      Cliente c = new Cliente();
      c.setNome("teste");
    }


}
