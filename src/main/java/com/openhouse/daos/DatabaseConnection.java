package com.openhouse.daos;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.net.URI;

class DatabaseConnection {
	private DatabaseConnection() {
		throw new UnsupportedOperationException("Do not instantiate!");
	}

    static Connection getConnection() throws URISyntaxException, SQLException {
    	final URI dbUri = new URI(System.getenv("DATABASE_URL"));

    	final String username = dbUri.getUserInfo().split(":")[0];
    	final String password = dbUri.getUserInfo().split(":")[1];

    	final String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }
}