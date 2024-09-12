package com.bionexo.hospital.services;

import com.bionexo.hospital.dto.ProdutoDto;
import com.bionexo.hospital.model.ProdutoModel;
import com.bionexo.hospital.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoService {
    public boolean verificarNome(String nome, long id);
    public ProdutoModel atualizarProduto(ProdutoDto produtoDto);
    public void deletarProduto(Long id);
    public List<ProdutoModel> findAll();
    public ProdutoModel save(ProdutoDto produtodto);

    public ProdutoDto listar(ProdutoDto produtoDto) {
        ProdutoModel produtoModel = ProdutosRepository.findById(id).orElse(null);
        if (produtoModel== null)
            return null;
    }
}
