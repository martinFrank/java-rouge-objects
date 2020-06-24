package com.github.martinfrank.javarouge.objects;

import com.github.martinfrank.javarouge.dao.RegistrationDaoExt;
import com.github.martinfrank.javarouge.generated.tables.pojos.Registration;
import org.jooq.Configuration;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class JooqTest {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:./test";

    // Database credentials
    private static final String USER = "sa";
    private static final String PASS = "";


    public static void main(String[] args) {

        // STEP 1: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            return;
        }

        // STEP 2: Open a connection
        System.out.println("Connecting to database...");
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {

            Configuration configuration = new DefaultConfiguration().set(connection).set(SQLDialect.H2);
            RegistrationDaoExt dao = new RegistrationDaoExt(configuration);

            List<Registration> registrationList = dao.fetchAll();
            for (Registration registration : registrationList) {
                System.out.println(registration);
            }

        } catch (SQLException e) {

        }

    }

}
