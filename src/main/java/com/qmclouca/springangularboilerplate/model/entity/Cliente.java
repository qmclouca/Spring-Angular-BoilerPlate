package com.qmclouca.springangularboilerplate.model.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel
public class Cliente{

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
