package com.kassioschaider.avaliacao.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
    private Long numeroDoTombo = geradorNumeroTombo();

    private Long geradorNumeroTombo() {
        return Timestamp.valueOf(LocalDateTime.now()).getTime();
    }
}
