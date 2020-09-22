package com.kassioschaider.avaliacao.service.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class MarcaDTO {

    private Long id;

    @NotEmpty(message = "Não pode estar vazio!")
    @Length(min = 3, max = 50, message = "Deve estar entre 3 e 50 letras!")
    private String nome;
}
