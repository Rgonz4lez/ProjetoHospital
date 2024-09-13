package com.bionexo.hospital.dto;

import java.time.Instant;

public class ProdutoDto {
    private long id;
    private String nome;
    private String descricao;
    private String status;
    private Instant dataCriacao;
    private Instant dataAlteracao;


    public ProdutoDto(Instant dataAlteracao, Instant dataCriacao, String descricao, long id, String nome, String status) {
        this.dataAlteracao = dataAlteracao;
        this.dataCriacao = dataCriacao;
        this.descricao = descricao;
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public long getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public Instant getDataAlteracao() {
        return dataAlteracao;
    }


    public void setId(long id) { this.id = id; };

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public  void setStatus(String status){
        this.status = status;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


    public void setDataAlteracao(Instant dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

}
