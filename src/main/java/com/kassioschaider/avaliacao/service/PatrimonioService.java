package com.kassioschaider.avaliacao.service;

import com.kassioschaider.avaliacao.service.dto.PatrimonioDTO;
import com.kassioschaider.avaliacao.service.dto.PatrimonioFormDTO;

import java.util.List;
import java.util.Optional;

public interface PatrimonioService {

    List<PatrimonioDTO> obterTodos();

    PatrimonioDTO cadastrar(PatrimonioFormDTO patrimonioFormDTO);

    PatrimonioDTO atualizar(PatrimonioFormDTO patrimonioFormDTO);

    Optional<PatrimonioDTO> obterPorId(Long id);

    void excluirPorId(Long id);
}
