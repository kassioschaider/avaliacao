package com.kassioschaider.avaliacao.service;

import com.kassioschaider.avaliacao.service.dto.MarcaDTO;

import java.util.List;
import java.util.Optional;

public interface MarcaService {

    List<MarcaDTO> obterTodos();

    MarcaDTO cadastrar(MarcaDTO marcaDTO);

    MarcaDTO atualizar(MarcaDTO marcaDTO);

    Optional<MarcaDTO> obterPorId(Long id);

    void excluirPorId(Long id);
}
