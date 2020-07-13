package com.github.martinfrank.javarouge.objects;

import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConfigurationProvider implements ConfigurationProvider, ConnectionProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(H2ConfigurationProvider.class);

    private final Connection connection;
    private final Configuration configuration;


    public H2ConfigurationProvider() throws SQLException, IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader(new File("src/main/resources/dbconfig.properties")));
        String jdbcDriver = properties.getProperty("com.github.martinfrank.javarouge.objects.db.driver");
        String dbUrl = properties.getProperty("com.github.martinfrank.javarouge.objects.db.url");

        String user = properties.getProperty("com.github.martinfrank.javarouge.objects.db.user");
        String pass = properties.getProperty("com.github.martinfrank.javarouge.objects.db.pass");
        String dialect = properties.getProperty("com.github.martinfrank.javarouge.objects.db.dialect");

        Class.forName(jdbcDriver);
        connection = DriverManager.getConnection(dbUrl, user, pass);
        configuration = new DefaultConfiguration().set(connection).set(SQLDialect.valueOf(dialect));
    }

    @Override
    public void close() throws IOException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Error while closing connection!", e);
                throw new IOException(e);
            }
        }
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

}
