package com.bionexo.hospital.transform;

import com.bionexo.hospital.dto.ProdutoDto;
import com.bionexo.hospital.model.ProdutoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {
    ProdutoMapper instance = Mappers.getMapper(ProdutoMapper.class);
    ProdutoModel mapToProdutoModel(ProdutoDto produtoDto);
    ProdutoDto mapProdutoDto(ProdutoModel produtoModel);
}
