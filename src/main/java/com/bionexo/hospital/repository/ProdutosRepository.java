package com.bionexo.hospital.repository;

import com.bionexo.hospital.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutoModel, Long> {

    boolean existsByNomeAndId(String nome, long id);

    boolean existsByNomeAndIdNot(String nome, long id);

    void deleteById(long id);
}
