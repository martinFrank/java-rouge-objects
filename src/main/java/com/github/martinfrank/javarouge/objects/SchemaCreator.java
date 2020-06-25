package com.github.martinfrank.javarouge.objects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class SchemaCreator {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:./test";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            // STEP 1: Register JDBC driver
//            Class.forName(JDBC_DRIVER);
//
//            //STEP 2: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//            //STEP 3: Execute a query
//            System.out.println("Creating table in given database...");
//            stmt = conn.createStatement();
//            String sql =  "CREATE TABLE IF NOT EXISTS REGISTRATION " +
//                    "(id INTEGER not NULL, " +
//                    " first VARCHAR(255), " +
//                    " last VARCHAR(255), " +
//                    " age INTEGER, " +
//                    " PRIMARY KEY ( id ))";
//            int updateStatus = stmt.executeUpdate(sql);
//            System.out.println("Created table in given database...");
//
//            // STEP 4: Clean-up environment
//            stmt.close();
//            conn.close();
//        } catch(SQLException se) {
//            //Handle errors for JDBC
//            se.printStackTrace();
//        } catch(Exception e) {
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            //finally block used to close resources
//            try{
//                if(stmt!=null) stmt.close();
//            } catch(SQLException se2) {
//            } // nothing we can do
//            try {
//                if(conn!=null) conn.close();
//            } catch(SQLException se){
//                se.printStackTrace();
//            } //end finally try
//        } //end try
//        System.out.println("Goodbye!");
//

        List<String> statements;
        try {
            Class.forName(JDBC_DRIVER);
            List<String> lines = Files.readAllLines(new File("src/main/resources/dbschema.sql").toPath());
//            List<String> lines = Files.readAllLines(new File("dbschema.sql").toPath());
            for (String sql : lines) {
                System.out.println("line: " + sql);
            }
            statements = lines.stream().filter(l -> l.charAt(0) != '#').collect(Collectors.toList());
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

        } catch (SQLException e) {
            System.out.println("error: " + e);
        }
    }
}
