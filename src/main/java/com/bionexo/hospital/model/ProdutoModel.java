package com.bionexo.hospital.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.Instant;

@Data
@Entity
@Table(name= "produtos")
public class ProdutoModel{

    @Id
    @Column(name = "id_produto", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_produto", nullable = false)
    private String nome;

    @Column(name = "descricao_produto")
    private String descricao;

    @Column(name = "status_produto")
    private String status;

    @Column(name = "dt_criacao")
    private Instant dataCriacao;

    @Column(name = "dt_alteracao")
    private Instant dataAlteracao;
}
