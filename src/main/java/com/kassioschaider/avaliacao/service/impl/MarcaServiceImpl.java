package com.kassioschaider.avaliacao.service.impl;

import com.kassioschaider.avaliacao.repository.MarcaRepository;
import com.kassioschaider.avaliacao.service.MarcaService;
import com.kassioschaider.avaliacao.service.dto.MarcaDTO;
import com.kassioschaider.avaliacao.service.mapper.MarcaMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MarcaMapper marcaMapper;

    @Override
    public List<MarcaDTO> obterTodos() {
        return marcaMapper.toDto(marcaRepository.findAll());
    }

    @Override
    public MarcaDTO cadastrar(MarcaDTO marcaDTO) {
        return null;
    }

    @Override
    public MarcaDTO atualizar(MarcaDTO marcaDTO) {
        return null;
    }

    @Override
    public Optional<MarcaDTO> obterPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public void excluirPorId(Long id) {

    }
}
