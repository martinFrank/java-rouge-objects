package com.github.martinfrank.javarouge.objects.csv;

import com.github.martinfrank.javarouge.objects.H2ConfigurationProvider;
import org.h2.tools.RunScript;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class SqlExecutor {

    private final SourceFileProvider sourceFileProvider;
    private final String dbSchemaFilename;
    private final H2ConfigurationProvider configurationProvider;
    private final String sqlDir;

    private static final String CSV = ".csv";
    private static final String SQL = ".sql";

    public SqlExecutor(H2ConfigurationProvider configurationProvider, SourceFileProvider sourceFileProvider, String sqlDir, String dbSchemaFilename) {
        this.configurationProvider = configurationProvider;
        this.sourceFileProvider = sourceFileProvider;
        this.sqlDir = sqlDir;
        this.dbSchemaFilename = dbSchemaFilename;
    }

    public void createDb() throws IOException, SQLException {
        createNewDb();
        insertData();

    }

    private void insertData() throws IOException, SQLException {
        for (String file : sourceFileProvider.getSourceFiles()) {
            File f = new File(sqlDir, toSql(file));
            System.out.println("executing file " + f);
            FileReader fr = new FileReader(f);
            RunScript.execute(configurationProvider.getConnection(), fr);
            fr.close();
        }
    }

    private void createNewDb() throws IOException, SQLException {
        FileReader fr = new FileReader(new File(dbSchemaFilename));
        RunScript.execute(configurationProvider.getConnection(), fr);
        fr.close();
    }


    private String toSql(String sourceFile) {
        return sourceFile.replace(CSV, SQL);
    }
}
