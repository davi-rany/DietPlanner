package com.example.djeta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UnidadeMedia {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String unidadeMedia;
}
