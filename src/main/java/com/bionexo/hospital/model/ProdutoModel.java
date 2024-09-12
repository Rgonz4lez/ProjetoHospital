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


    public long getId(){
        return id;
    }

    public void setId(long id) { this.id = id; };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public  void setStatus(String status){
        this.status = status;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Instant getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Instant dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
