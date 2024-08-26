package com.bionexo.hospital.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ProdutoDto {
    private long id;
    private String nome;
    private String descricao;
    private String status;
    private Instant dataCriacao;
    private Instant dataAlteracao;
}
