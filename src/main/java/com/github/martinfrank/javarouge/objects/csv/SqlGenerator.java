package com.github.martinfrank.javarouge.objects.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;

public class SqlGenerator {

    private final String sourceDir;
    private final String templateDir;
    private final String targetDir;
    private final SourceFileProvider sourceFileProvider;

    private static final String CSV = ".csv";
    private static final String TEMPLATE = ".sql.template";
    private static final String SQL = ".sql";

    public SqlGenerator(SourceFileProvider sourceFileProvider, String sourceDir, String templateDir, String targetDir) {
        this.sourceFileProvider = sourceFileProvider;
        this.sourceDir = sourceDir;
        this.templateDir = templateDir;
        this.targetDir = targetDir;
    }

    public void generate() throws IOException, URISyntaxException {
        for (String sourceFile : sourceFileProvider.getSourceFiles()) {
            generate(sourceFile);
        }
    }

    private void generate(String sourceFile) throws IOException, URISyntaxException {
        //Paths.get(ClassLoader.getSystemResource(filename).toURI());
        System.out.println(new File(sourceDir, sourceFile).toString());
        List<String[]> source = CsvUtility.readCsvFile(new File(sourceDir, sourceFile).toString());
        String template = new String(Files.readAllBytes(new File(templateDir, toTemplate(sourceFile)).toPath()));
        File f = new File(targetDir, toSql(sourceFile));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f))) {
            for (String[] data : source) {
                String line = String.format(template, data) + "\n";
                bufferedWriter.write(line);
            }
        }
    }

    private String toTemplate(String sourceFile) {
        return sourceFile.replace(CSV, TEMPLATE);
    }

    private String toSql(String sourceFile) {
        return sourceFile.replace(CSV, SQL);
    }

}
