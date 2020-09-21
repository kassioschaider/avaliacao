package com.kassioschaider.avaliacao.service.mapper;

import com.kassioschaider.avaliacao.model.Marca;
import com.kassioschaider.avaliacao.service.dto.MarcaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface MarcaMapper extends EntityMapper<MarcaDTO, Marca>{}
