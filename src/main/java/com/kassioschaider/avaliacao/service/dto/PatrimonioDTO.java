package com.kassioschaider.avaliacao.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatrimonioDTO {

    private Long id;
    private String nome;
    private Long idMarca;
    private String descricao;
    private Long numeroDoTombo;
}
