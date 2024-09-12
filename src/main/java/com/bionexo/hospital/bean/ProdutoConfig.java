package com.bionexo.hospital.bean;

import com.bionexo.hospital.repository.ProdutosRepository;
import com.bionexo.hospital.services.ProdutoService;
import com.bionexo.hospital.services.ProdutoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoConfig {

    @Bean
    public ProdutoService produtoService(ProdutosRepository produtosRepository){
        return new ProdutoServiceImpl(produtosRepository);
    }
}
