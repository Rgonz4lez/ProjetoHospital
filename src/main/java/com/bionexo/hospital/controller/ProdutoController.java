package com.bionexo.hospital.controller;

import com.bionexo.hospital.dto.ProdutoDto;
import com.bionexo.hospital.model.ProdutoModel;
import com.bionexo.hospital.repository.ProdutosRepository;
import com.bionexo.hospital.services.ProdutoService;
import com.bionexo.hospital.transform.ProdutoMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public List<ProdutoDto>  listar() {
        return produtoService.findAll();
    }

    @PostMapping("/inserirProduto")
    @ResponseStatus(HttpStatus.CREATED)

    public  ProdutoDto save(@RequestBody ProdutoDto produtoDto){
        return produtoService.save(produtoDto);
    };

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDto editProdutos(@RequestBody ProdutoDto produtoDto){
        return produtoService.atualizarProduto(produtoDto);
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
