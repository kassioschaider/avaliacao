package com.kassioschaider.avaliacao.controller;

import com.kassioschaider.avaliacao.model.Patrimonio;
import com.kassioschaider.avaliacao.service.dto.PatrimonioDTO;
import com.kassioschaider.avaliacao.service.dto.PatrimonioFormDTO;
import com.kassioschaider.avaliacao.service.mapper.PatrimonioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PatrimonioController {

    @Autowired
    private PatrimonioMapper patrimonioMapper;

    @GetMapping("/patrimonios")
    public List<PatrimonioDTO> listar() {
        Patrimonio patrimonio = new Patrimonio();

        return patrimonioMapper.toDto(Arrays.asList(patrimonio, patrimonio, patrimonio));
    }
}
