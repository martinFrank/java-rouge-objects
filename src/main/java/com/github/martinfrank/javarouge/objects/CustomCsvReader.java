package com.github.martinfrank.javarouge.objects;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomCsvReader {

    public static void main(String[] args) {
        try (Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource("csv/test.csv").toURI()));
             CSVReader csvReader = new CSVReader(reader)) {
            List<String[]> list = csvReader.readAll();
            list.forEach(e -> System.out.println(Arrays.toString(e)));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> readAll(Reader reader) throws Exception {
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> list = new ArrayList<>();
        list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }

}
