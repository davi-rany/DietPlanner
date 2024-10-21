package com.example.djeta.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Alimento {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "tipo_alimento_id")
    private TipoAlimento tipoAlimento;

}
