package com.kassioschaider.avaliacao.service.mapper;

import com.kassioschaider.avaliacao.model.Patrimonio;
import com.kassioschaider.avaliacao.service.dto.PatrimonioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface PatrimonioMapper extends EntityMapper<PatrimonioDTO, Patrimonio>{

    @Override
    @Mapping(source = "idMarca", target = "marca.id")
    Patrimonio toEntity(PatrimonioDTO dto);

    @Override
    @Mapping(source = "marca.id", target = "idMarca")
    PatrimonioDTO toDto(Patrimonio entity);
}
