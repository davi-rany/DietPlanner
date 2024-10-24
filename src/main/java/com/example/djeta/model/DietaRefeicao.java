package com.example.djeta.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DietaRefeicao {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "dieta_id")
    private Dieta dieta;
    @ManyToOne
    @JoinColumn(name = "refeicao_id")
    private Refeicao refeicao;
}
