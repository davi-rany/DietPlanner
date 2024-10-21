package com.example.djeta.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AlimentoNutriente {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "alimento_id")
    private Alimento alimento;
    @ManyToOne
    @JoinColumn(name = "nutriente_id")
    private Nutriente nutriente;
    private Double value;
}
