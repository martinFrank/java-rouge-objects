package com.github.martinfrank.javarouge.objects;

import java.sql.Connection;

public interface ConnectionProvider {

    Connection getConnection();
}
