package com.github.martinfrank.javarouge.objects.csv;

import java.util.List;
import java.util.stream.Collectors;

public class SourceFileProvider {

    private final List<String> sourceFiles;

    public SourceFileProvider(String file) {
        sourceFiles = mapCsvContent(CsvUtility.readCsvFile(file));
    }

    private List<String> mapCsvContent(List<String[]> csvContent) {
        return csvContent.stream().map(e -> e[0]).collect(Collectors.toList());
    }

    public List<String> getSourceFiles() {
        return sourceFiles;
    }
}
