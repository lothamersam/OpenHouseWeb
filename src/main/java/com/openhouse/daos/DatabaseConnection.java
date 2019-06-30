package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.net.URI;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() throws URISyntaxException, SQLException {
        if (connection == null) {
            URI dbUri = new URI(System.getenv("DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];

            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            connection = DriverManager.getConnection(dbUrl, username, password);
        }

        return connection;
    }
}