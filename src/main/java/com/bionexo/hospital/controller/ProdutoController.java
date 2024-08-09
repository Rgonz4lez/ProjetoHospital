package com.bionexo.hospital.controller;

import com.bionexo.hospital.model.Produtos;
import com.bionexo.hospital.repository.ProdutosRepository;
import jakarta.persistence.Id;
import org.apache.logging.log4j.message.Message;
import org.hibernate.annotations.JavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/inserirProduto")
    @ResponseStatus(HttpStatus.CREATED)
    public  Produtos save(@RequestBody Produtos produtos){
        return ProdutosRepository.save(produtos);
    };

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Produtos editProdutos(@RequestBody Produtos produtos){
      return ProdutosRepository.save(produtos);
    };

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        ProdutosRepository.deleteById(id);
    };

}
