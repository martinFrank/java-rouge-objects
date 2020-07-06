package com.github.martinfrank.javarouge.objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class SchemaCreator {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    //private static final String DB_URL = "jdbc:h2:./test";
    private static final String DB_URL = "jdbc:h2:./objects";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static void main(String[] args) {

        List<String> statements;
        try {
            Class.forName(JDBC_DRIVER);
            List<String> lines = Files.readAllLines(new File("src/main/resources/sql/dbschema.sql").toPath());
            statements = lines.stream().filter(l -> l.trim().length() > 0 && l.trim().charAt(0) != '#').collect(Collectors.toList());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("error: " + e);
            return;
        }

        // STEP 2: Open a connection
        System.out.println("Connecting to database...");
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = connection.createStatement();
            for (String sql : statements) {
                stmt.executeUpdate(sql);
                System.out.println("execute sql: " + sql);
            }
            stmt.close();

        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
}
