package com.bionexo.hospital.transform;

import com.bionexo.hospital.dto.ProdutoDto;
import com.bionexo.hospital.model.ProdutoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProdutoMapper {
    ProdutoMapper instance = Mappers.getMapper(ProdutoMapper.class);
    ProdutoModel mapToProdutoModel(ProdutoDto produtoDto);
    ProdutoDto mapProdutoDto(ProdutoModel produtoModel);
    List<ProdutoDto> mapProdutoList(List<ProdutoModel> produtoModel);
}