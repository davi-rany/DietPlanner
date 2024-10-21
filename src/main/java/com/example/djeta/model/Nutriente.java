package com.example.djeta.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Nutriente {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "unidade_media_id")
    private UnidadeMedia unidadeMedia;
}
