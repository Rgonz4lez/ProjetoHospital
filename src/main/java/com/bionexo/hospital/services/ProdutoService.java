package com.bionexo.hospital.services;

import com.bionexo.hospital.dto.ProdutoDto;
import com.bionexo.hospital.exception.ProdutoExistenteException;
import com.bionexo.hospital.model.ProdutoModel;
import com.bionexo.hospital.repository.ProdutosRepository;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Instant;

public class ProdutoService {
    private ProdutosRepository produtosRepository;

    public boolean verificarNome(String nome, long id){
        return produtosRepository.existsById( nome, id);
    }
    public ProdutoModel atualizarProduto(ProdutoDto produtoDto){
        ProdutoModel produtoExistente = produtosRepository.findById(produtoDto.getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (produtosRepository.existsByNomeAndIdNot(produtoExistente.getNome(), produtoDto.getId())){
            throw new ProdutoExistenteException("Nome do produto ja está sendo utilizado.");
        }

        produtoExistente.setNome(produtoDto.getNome());
        produtoExistente.setDescricao(produtoDto.getDescricao());
        produtoExistente.setStatus(produtoDto.getStatus());
        produtoExistente.setDataAlteracao(Instant.now());
        return produtosRepository.save(produtoExistente);
    }

    public void deletarProduto(Long id) {
        if (!produtosRepository.existsById(id)){
            throw new RuntimeException("Produto não encontrado:" + id);
        }
        produtosRepository.deletarProduto(id);
    }
}
