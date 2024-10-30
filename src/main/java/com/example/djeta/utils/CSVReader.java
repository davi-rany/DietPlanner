package com.example.djeta.utils;

import com.example.djeta.service.NutrienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

@Component
public class CSVReader {

    @Autowired
    private NutrienteService nutrienteService;

    public Map<Integer, String> readCSV(String filePath) {
        Map<Integer, String> nutrienteUnidadeMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> nutrientes = br.lines()
                    .peek(System.out::println)
                    .filter(line -> line.contains("Número do Alimento"))
                    .flatMap(line -> Arrays.stream(line.split(",")))
                    .filter(column -> column.contains("("))
                    .toList();

            IntStream.range(0, nutrientes.size())
                    .forEach(index -> nutrienteUnidadeMap.put(index, parseNutriente(nutrientes.get(index))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nutrienteUnidadeMap;
    }

    private String parseNutriente(String nutriente) {
        String[] split = nutriente.split("\\(");
        if (split.length == 2) {
            String nome = split[0].trim();
            String unidade = split[1].replace(")", "").trim();
            return nome + "," + unidade;
        }
        return nutriente;
    }

    public void insertNutrientesInDb() {
        Map<Integer, String> nutrientes = readCSV("/home/daniel/Downloads/Taco-4a-Edicao.csv");
        nutrientes.forEach((key, nutriente) -> {
            String[] split = nutriente.split(",");
            String name = split[0].trim();
            String measureUnit = split[1].trim();
            nutrienteService.insertNutriente(name, measureUnit);
        });
    }
}
