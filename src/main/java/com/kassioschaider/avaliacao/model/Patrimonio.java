package com.kassioschaider.avaliacao.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class Patrimonio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Marca marca;
    private String descricao;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroDoTombo;
}
