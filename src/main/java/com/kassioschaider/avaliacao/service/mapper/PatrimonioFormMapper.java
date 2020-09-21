package com.kassioschaider.avaliacao.service.mapper;

import com.kassioschaider.avaliacao.model.Patrimonio;
import com.kassioschaider.avaliacao.service.dto.PatrimonioFormDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface PatrimonioFormMapper extends EntityMapper<PatrimonioFormDTO, Patrimonio>{

    @Override
    @Mapping(source = "idMarca", target = "marca.id")
    Patrimonio toEntity(PatrimonioFormDTO dto);

    @Override
    @Mapping(source = "marca.id", target = "idMarca")
    PatrimonioFormDTO toDto(Patrimonio entity);
}
