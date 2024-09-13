package com.bionexo.hospital.services;

import com.bionexo.hospital.dto.ProdutoDto;
import com.bionexo.hospital.model.ProdutoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoService {
    public boolean verificarNome(String nome, long id);
    public ProdutoDto atualizarProduto(ProdutoDto produtoDto);
    public void deletarProduto(Long id);
    public List<ProdutoDto> findAll();
    public ProdutoDto save(ProdutoDto produtodto);
}
