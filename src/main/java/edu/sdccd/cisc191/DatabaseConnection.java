package edu.sdccd.cisc191;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Provides methods to establish a connection to the database and manage database schema.
 * This class includes functionality to connect to a PostgreSQL database and create a "Book" table if it doesn't already exist.
 */
public class DatabaseConnection {

    /**
     * The JDBC URL for the database, including the database name.
     */
    private static final String URL = "jdbc:postgresql://library.cj3nkanaqkce.us-east-1.rds.amazonaws.com:5432/postgres";

    /**
     * The username for accessing the database.
     */
    private static final String USER = "postgres";

    /**
     * The password for accessing the database.
     */
    private static final String PASSWORD = "Sdccdcisc191";


    /**
     * Establishes and returns a connection to the PostgreSQL database.
     *
     * @return a {@link Connection} object to interact with the database
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        // Use DriverManager to establish a connection to the database
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Creates the "Book" table in the database if it doesn't already exist.
     * The table has two columns:
     * <ul>
     *     <li><strong>id</strong>: a unique identifier for each book (Primary Key, auto-incremented).</li>
     *     <li><strong>bookName</strong>: the name of the book (VARCHAR, not null).</li>
     * </ul>
     */
    public static void createBookTable()
    {
        // SQL query to create the Book table if it doesn't exist
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Book ("
                + "id SERIAL PRIMARY KEY, "
                + "bookName VARCHAR(255) NOT NULL"
                + ");";

        // Establish a connection and execute the SQL query
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            // Execute the create table SQL query
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'Book' has been created or already exists.");
        } catch (SQLException e) {
            // Print error details if the table creation fails
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
}
