package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/day3"; // change to your DB URL
    private static final String USER = "root"; 
    private static final String PASSWORD = "Incedo@1234"; 
    public static Connection getConnection() throws SQLException {
        try {
            // Try to establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            // Print the error message if connection fails
            System.out.println("Error: Could not connect to the database.");
            throw e; // Rethrow the exception so it can be handled higher up (like in MainClass)
        }
    }
}
