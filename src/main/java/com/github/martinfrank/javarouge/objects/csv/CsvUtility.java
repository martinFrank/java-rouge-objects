package com.github.martinfrank.javarouge.objects.csv;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CsvUtility {

    public static List<String[]> readCsvFile(String filename) {
        try (Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource(filename).toURI()));
             CSVReader csvReader = new CSVReader(reader)) {
            List<String[]> raw = csvReader.readAll();
            return raw.stream().filter(a -> a[0].length() > 0).collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
