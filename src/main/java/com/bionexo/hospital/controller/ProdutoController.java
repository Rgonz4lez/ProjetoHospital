package com.bionexo.hospital.controller;

import com.bionexo.hospital.dto.ProdutoDto;
import com.bionexo.hospital.exception.ProdutoExistenteException;
import com.bionexo.hospital.model.ProdutoModel;
//import com.bionexo.hospital.model.Produtos;
import com.bionexo.hospital.repository.ProdutosRepository;
//import jakarta.persistence.Id;
//import org.apache.logging.log4j.message.Message;
//import org.hibernate.annotations.JavaType;
import com.bionexo.hospital.services.ProdutoService;
import com.bionexo.hospital.transform.ProdutoMapper;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

    @Autowired
    private ProdutosRepository ProdutosRepository;

//    @Autowired
//    private ModelMapper;

    @GetMapping("/listar")
    public List <ProdutoModel> listar() {
        return ProdutosRepository.findAll();
    }

    @PostMapping("/inserirProduto")
    @ResponseStatus(HttpStatus.CREATED)
    public  ProdutoModel save(@RequestBody ProdutoDto ProdutoDto){
        ProdutoModel produtos = new ProdutoModel();
        produtos.setDescricao(ProdutoDto.getDescricao());
        produtos.setNome(ProdutoDto.getNome());
        produtos.setId(ProdutoDto.getId());
        produtos.setStatus(ProdutoDto.getStatus());
        produtos.setDataCriacao(Instant.now());
        produtos.setDataAlteracao(Instant.now());
        produtos = ProdutoMapper.instance.mapToProdutoModel(ProdutoDto);
        return ProdutosRepository.save(produtos);
    };

    @Autowired
    private ProdutoService produtoService;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDto editProdutos(@RequestBody ProdutoDto produtoDto){
            ProdutoModel produtoAtualizado = produtoService.atualizarProduto(produtoDto);
            return ProdutoMapper.instance.mapProdutoDto(produtoAtualizado);
    };

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        try {
            produtoService.deletarProduto(id);
            return ResponseEntity.ok("Produto excluído com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
