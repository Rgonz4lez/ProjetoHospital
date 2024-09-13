package com.bionexo.hospital.services;

import com.bionexo.hospital.dto.ProdutoDto;
import com.bionexo.hospital.exception.ProdutoExistenteException;
import com.bionexo.hospital.model.ProdutoModel;
import com.bionexo.hospital.repository.ProdutosRepository;
import com.bionexo.hospital.transform.ProdutoMapper;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.List;


@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{

    private ProdutosRepository produtosRepository;

    @Override
    public List<ProdutoDto> findAll(){return ProdutoMapper.instance.mapProdutoList(produtosRepository.findAll());}

    @Override
    public boolean verificarNome(String nome, long id){
        return produtosRepository.existsByNomeAndId( nome, id);
    }

    @Override
    public ProdutoDto atualizarProduto(ProdutoDto produtoDto){
        ProdutoModel produtoExistente = produtosRepository.findById(produtoDto.getId()).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (produtosRepository.existsByNomeAndIdNot(produtoExistente.getNome(), produtoDto.getId())){
            throw new ProdutoExistenteException("Nome do produto ja está sendo utilizado.");
        }

        produtoExistente.setNome(produtoDto.getNome());
        produtoExistente.setDescricao(produtoDto.getDescricao());
        produtoExistente.setStatus(produtoDto.getStatus());
        produtoExistente.setDataAlteracao(Instant.now());
        return ProdutoMapper.instance.mapProdutoDto(produtosRepository.save(produtoExistente));
    }

    @Override
    public void deletarProduto(Long id) {
        if (!produtosRepository.existsById(id)){
            throw new RuntimeException("Produto não encontrado:" + id);
        }
        produtosRepository.deleteById(id);
    }

    @Override
    public ProdutoDto save(ProdutoDto produtoDto) {
        ProdutoModel produtos = new ProdutoModel();
        produtos.setDescricao(produtoDto.getDescricao());
        produtos.setNome(produtoDto.getNome());
        produtos.setId(produtoDto.getId());
        produtos.setStatus(produtoDto.getStatus());
        produtos.setDataCriacao(Instant.now());
        produtos.setDataAlteracao(Instant.now());
        return ProdutoMapper.instance.mapProdutoDto(produtosRepository.save(produtos));
    }
}
