package com.example.djeta.utils;

import com.example.djeta.model.Nutriente;
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

    public Map<String, Map<Integer, Object>> readCSV(String filePath) {
        Map<Integer, Object> nutrienteUnidadeMap = new HashMap<>();
        Map<Integer, Object> tipoAlimentoMap = new HashMap<>();
        Map<String, Map<Integer, Object>> csvTablesMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> nutrientes = getNutrientesFromCsvFile(br);
            populateNutrienteUnidadeMap(nutrientes, nutrienteUnidadeMap);
            csvTablesMap.put("nutrientes", nutrienteUnidadeMap);


            csvTablesMap.put("tipo_alimento", nutrienteUnidadeMap);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return csvTablesMap;
    }

    private void populateNutrienteUnidadeMap(List<String> nutrientes, Map<Integer, Object> nutrienteUnidadeMap) {
        for (int i = 1; i <= nutrientes.size(); i++) {
            String[] split = nutrientes.get(i-1).split("\\(");

            if (split.length == 2) {
                String name = split[0].trim();
                String unitMeasure = split[1].replace(")", "").trim();
                Nutriente nutriente1 = new Nutriente(i, name, unitMeasure);
                nutrienteUnidadeMap.put(i, nutriente1);
            }

        }
    }

    private static List<String> getNutrientesFromCsvFile(BufferedReader br) {
        return br.lines()
                .peek(System.out::println)
                .filter(line -> line.contains("Número do Alimento"))
                .flatMap(line -> Arrays.stream(line.split(",")))
                .filter(column -> column.contains("("))
                .toList();
    }

    public void insertNutrientesInDb() {
        Map<String, Map<Integer, Object>> csvTablesMap = readCSV("/home/daniel/Downloads/Taco-4a-Edicao.csv");
        Map<Integer, Object> nutrientes = csvTablesMap.get("nutrientes");
        nutrientes.forEach((key, nutriente) -> {
            System.out.printf("Inserting the element: \n%s%n", nutriente.toString());
//            nutrienteService.insertNutriente((Nutriente) nutriente);
        });
    }
}
