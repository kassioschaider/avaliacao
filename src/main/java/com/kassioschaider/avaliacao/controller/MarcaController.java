package com.kassioschaider.avaliacao.controller;

import com.kassioschaider.avaliacao.model.Marca;
import com.kassioschaider.avaliacao.service.MarcaService;
import com.kassioschaider.avaliacao.service.dto.MarcaDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
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

    @PostMapping("/marcas")
    @Transactional
    public ResponseEntity<MarcaDTO> cadastrar(@RequestBody @Valid MarcaDTO marcaDTO, UriComponentsBuilder uriBuilder) {
        MarcaDTO result = marcaService.cadastrar(marcaDTO);
        return ResponseEntity.created(uriBuilder.path("/marcas/{id}")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }
}
