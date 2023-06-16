package com.qmclouca.springangularboilerplate.model.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Entity
@Data
public class baseEntity {

    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    private UUID id;

    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private LocalDateTime dataCriacao;

    @Column
    private LocalDateTime dataAlteracao;
}
