package com.example.djeta.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CSVReader csvReader;

    @Autowired
    public DataInitializer(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public void run(String... args) {
//        csvReader.insertNutrientesInDb();
    }
}
