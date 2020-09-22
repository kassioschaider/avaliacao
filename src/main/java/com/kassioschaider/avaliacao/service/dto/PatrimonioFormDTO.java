package com.kassioschaider.avaliacao.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatrimonioFormDTO {

    private Long id;
    @NotEmpty(message = "Não pode estar vazio!")
    @Length(min = 3, max = 50, message = "Deve estar entre 3 e 50 letras!")
    private String nome;
    @NotNull(message = "Marca não selecionada!")
    private Long idMarca;
    private String descricao;
}
