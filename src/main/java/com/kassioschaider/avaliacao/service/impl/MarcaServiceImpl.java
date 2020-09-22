package com.kassioschaider.avaliacao.service.impl;

import com.kassioschaider.avaliacao.model.Marca;
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
    private final MarcaRepository marcaRepository;

    @Autowired
    private final MarcaMapper marcaMapper;

    @Override
    public List<MarcaDTO> obterTodos() {
        return marcaMapper.toDto(marcaRepository.findAll());
    }

    @Override
    public MarcaDTO cadastrar(MarcaDTO marcaDTO) {
        Marca marca = marcaMapper.toEntity(marcaDTO);
        return marcaMapper.toDto(marcaRepository.save(marca));
    }

    @Override
    public MarcaDTO atualizar(MarcaDTO marcaDTO) {
        Marca marca = marcaMapper.toEntity(marcaDTO);
        return marcaMapper.toDto(marcaRepository.save(marca));
    }

    @Override
    public Optional<MarcaDTO> obterPorId(Long id) {
        return marcaRepository.findById(id).map(marcaMapper::toDto);
    }

    @Override
    public void excluirPorId(Long id) {
        marcaRepository.deleteById(id);
    }
}
