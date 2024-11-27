package edu.sdccd.cisc191;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // JDBC URL for the database, including the database name
    private static final String URL = "jdbc:postgresql://database-1.c1gecos0z57s.us-east-1.rds.amazonaws.com:5432/todolist";

    // Username for accessing the database
    private static final String USER = "postgres";

    // Password for accessing the database
    private static final String PASSWORD = "5550025498";


    /**
     * Establishes and returns a connection to the MySQL database.
     *
     * @return A Connection object to interact with the database.
     * @throws SQLException If a database access error occurs.
     */
    public static Connection getConnection() throws SQLException {
        // Use DriverManager to establish a connection to the database
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
