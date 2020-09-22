package com.kassioschaider.avaliacao.controller;

import com.kassioschaider.avaliacao.service.PatrimonioService;
import com.kassioschaider.avaliacao.service.dto.PatrimonioDTO;
import com.kassioschaider.avaliacao.service.dto.PatrimonioFormDTO;
import com.kassioschaider.avaliacao.service.mapper.PatrimonioMapper;
import com.kassioschaider.avaliacao.util.ResponseUtil;
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
public class PatrimonioController {

    @Autowired
    private final PatrimonioMapper patrimonioMapper;

    @Autowired
    private final PatrimonioService patrimonioService;

    @GetMapping("/patrimonios")
    public List<PatrimonioDTO> listar() {
        return patrimonioService.obterTodos();
    }

    @PostMapping("/patrimonios")
    @Transactional
    public ResponseEntity<PatrimonioDTO> cadastrar(@RequestBody @Valid PatrimonioFormDTO patrimonioFormDTO, UriComponentsBuilder uriBuilder) {
        PatrimonioDTO result = patrimonioService.cadastrar(patrimonioFormDTO);
        return ResponseEntity.created(uriBuilder.path("/patrimonios/{id}")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @PutMapping("/patrimonios")
    @Transactional
    public ResponseEntity<PatrimonioDTO> atualizar(@RequestBody @Valid PatrimonioFormDTO patrimonioFormDTO, UriComponentsBuilder uriBuilder) {
        PatrimonioDTO result = patrimonioService.atualizar(patrimonioFormDTO);
        return ResponseEntity.created(uriBuilder.path("/patrimonios/{id}")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @GetMapping("/patrimonios/{id}")
    public ResponseEntity<PatrimonioDTO> obterPorId(@PathVariable Long id) {
        return ResponseUtil.wrapOrNotFound(patrimonioService.obterPorId(id));
    }

    @DeleteMapping("/patrimonios/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        patrimonioService.excluirPorId(id);
        return ResponseEntity.ok().build();
    }
}
