package com.example.djeta.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Dieta {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private Date startDate;
    private Date endDate;
}
