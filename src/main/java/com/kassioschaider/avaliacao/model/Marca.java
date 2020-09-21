package com.kassioschaider.avaliacao.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "nome", name = "marca_uk"))
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class Marca {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
