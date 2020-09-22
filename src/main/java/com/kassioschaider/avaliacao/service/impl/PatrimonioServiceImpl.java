package com.kassioschaider.avaliacao.service.impl;

import com.kassioschaider.avaliacao.model.Marca;
import com.kassioschaider.avaliacao.model.Patrimonio;
import com.kassioschaider.avaliacao.repository.PatrimonioRepository;
import com.kassioschaider.avaliacao.service.PatrimonioService;
import com.kassioschaider.avaliacao.service.dto.PatrimonioDTO;
import com.kassioschaider.avaliacao.service.dto.PatrimonioFormDTO;
import com.kassioschaider.avaliacao.service.mapper.PatrimonioFormMapper;
import com.kassioschaider.avaliacao.service.mapper.PatrimonioMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatrimonioServiceImpl implements PatrimonioService {

    @Autowired
    private final PatrimonioRepository patrimonioRepository;

    @Autowired
    private final PatrimonioMapper patrimonioMapper;

    @Autowired
    private final PatrimonioFormMapper patrimonioFormMapper;

    @Override
    public List<PatrimonioDTO> obterTodos() {
        return patrimonioMapper.toDto(patrimonioRepository.findAll());
    }

    @Override
    public PatrimonioDTO cadastrar(PatrimonioFormDTO patrimonioFormDTO) {
        Patrimonio patrimonio = patrimonioFormMapper.toEntity(patrimonioFormDTO);
        return patrimonioMapper.toDto(patrimonioRepository.save(patrimonio));
    }

    @Override
    public PatrimonioDTO atualizar(PatrimonioFormDTO patrimonioFormDTO) {
        Patrimonio patrimonio = patrimonioFormMapper.toEntity(patrimonioFormDTO);
        patrimonio.setNumeroDoTombo(patrimonioRepository
                .findById(patrimonio.getId()).get().getNumeroDoTombo());
        return patrimonioMapper.toDto(patrimonioRepository.save(patrimonio));
    }

    @Override
    public Optional<PatrimonioDTO> obterPorId(Long id) {
        return patrimonioRepository.findById(id).map(patrimonioMapper::toDto);
    }

    @Override
    public void excluirPorId(Long id) {
        patrimonioRepository.deleteById(id);
    }
}
