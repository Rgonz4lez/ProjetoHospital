package com.bionexo.hospital.controller;

import com.bionexo.hospital.model.Produtos;
import com.bionexo.hospital.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

    @Autowired
    private ProdutosRepository ProdutosRepository;

    @GetMapping("/listar")
    public List <Produtos> listar() {
        return ProdutosRepository.findAll();
    }

    @PostMapping
    public Produtos adicionar(@RequestBody Produtos produtos){
        return ProdutosRepository.save(produtos);
    }
}
