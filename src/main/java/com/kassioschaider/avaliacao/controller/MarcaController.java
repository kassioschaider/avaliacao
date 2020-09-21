package com.kassioschaider.avaliacao.controller;

import com.kassioschaider.avaliacao.service.MarcaService;
import com.kassioschaider.avaliacao.service.dto.MarcaDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MarcaController {

    @Autowired
    private final MarcaService marcaService;

    @GetMapping("/marcas")
    public List<MarcaDTO> obterTodos() {
        return marcaService.obterTodos();
    }
}
