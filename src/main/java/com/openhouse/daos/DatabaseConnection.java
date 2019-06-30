package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() throws URISyntaxException, SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(System.getenv("DATABASE_URL"));
        }

        return connection;
    }
}