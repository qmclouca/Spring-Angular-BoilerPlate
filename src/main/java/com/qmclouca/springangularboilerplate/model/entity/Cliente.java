package com.qmclouca.springangularboilerplate.model.entity;

import lombok.Data;
import jakarta.persistence.*;

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
