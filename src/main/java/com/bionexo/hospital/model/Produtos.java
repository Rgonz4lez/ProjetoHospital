package com.bionexo.hospital.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Produtos")
public class Produtos {

    @Id
    @Column(name = "id_produto", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
}