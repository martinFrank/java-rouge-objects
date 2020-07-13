package com.github.martinfrank.javarouge.objects.csv;

import com.github.martinfrank.javarouge.objects.H2ConfigurationProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Properties;

public class CsvDbGenerator {

    public static void main(String[] args) throws IOException, URISyntaxException {
        new CsvDbGenerator().generate();
    }

    private void generate() throws IOException, URISyntaxException {
        Properties properties = new Properties();
        properties.load(new FileReader(new File("src/main/resources/csv/csvsettings.properties")));
        String templateFiles = properties.getProperty("com.github.martinfrank.javarouge.objects.csv.templateFiles");

        String sourceDir = properties.getProperty("com.github.martinfrank.javarouge.objects.csv.csvDataDirectory");
        String templateDir = properties.getProperty("com.github.martinfrank.javarouge.objects.csv.templateDirectory");
        String targetDir = properties.getProperty("com.github.martinfrank.javarouge.objects.csv.sqlTargetDir");

        String dbFilename = properties.getProperty("com.github.martinfrank.javarouge.objects.db.dbfile");

        String schemaFile = properties.getProperty("com.github.martinfrank.javarouge.objects.csv.schemaFile");
        SourceFileProvider sourceFileProvider = new SourceFileProvider(templateFiles);
        SqlGenerator sqlGenerator = new SqlGenerator(sourceFileProvider, sourceDir, templateDir, targetDir);
        sqlGenerator.generate();

        deleteExistingDb(dbFilename);

        try (H2ConfigurationProvider configurationProvider = new H2ConfigurationProvider()) {
            SqlExecutor sqlExecutor = new SqlExecutor(configurationProvider, sourceFileProvider, targetDir, schemaFile);
            sqlExecutor.createDb();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void deleteExistingDb(String dbFileName) {
        File h2dbFile = new File(dbFileName);
        if (h2dbFile.exists()) {
            System.out.println("db file: " + h2dbFile);
            System.out.println("exists");
            if (h2dbFile.delete()) {
                System.out.println("successfully deleted");
            }
        }
    }
}
