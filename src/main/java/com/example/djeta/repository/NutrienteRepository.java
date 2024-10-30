package com.example.djeta.repository;

import com.example.djeta.model.Nutriente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutrienteRepository extends JpaRepository<Nutriente, Integer> {

}
