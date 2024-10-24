package com.example.djeta.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AlimentoRefeicao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "alimento_id")
    private Alimento alimento;
    @ManyToOne
    @JoinColumn(name = "refeicao_id")
    private Refeicao refeicao;
}
