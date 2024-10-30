package com.example.djeta.service;
import com.example.djeta.model.Nutriente;
import com.example.djeta.repository.NutrienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutrienteService {

    @Autowired
    private NutrienteRepository nutrienteRepository;

    public void insertNutriente(String name, String unitMeasure) {
        Nutriente nutriente = new Nutriente();
        nutriente.setName(name);
        nutriente.setMeasureUnit(unitMeasure);
        nutrienteRepository.save(nutriente);
    }
}
