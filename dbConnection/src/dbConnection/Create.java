package dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {

    public static void createTable() {
        String createTableQuery = 
            "CREATE TABLE IF NOT EXISTS employees (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "name VARCHAR(255) NOT NULL, " +
            "age INT NOT NULL, " +
            "salary float NOT NULL" +
            ");";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(createTableQuery)) {

            stmt.executeUpdate(); // Execute the table creation statement
            System.out.println("Table 'employees' created successfully (if it didn't exist already).");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
