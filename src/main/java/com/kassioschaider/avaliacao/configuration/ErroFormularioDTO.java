package com.kassioschaider.avaliacao.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErroFormularioDTO {

    private String campo;
    private String erro;
}
