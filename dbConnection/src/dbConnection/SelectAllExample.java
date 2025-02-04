package dbConnection;

import java.sql.*;

public class SelectAllExample {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sample";
        String user = "root";
        String password = "Incedo@1234";

        // JDBC objects
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the JDBC driver (optional for modern versions)
            Class.forName("com.mysql.cj.jdbc.Driver"); // For MySQL. Adjust for your DB.

            // Connect to the database
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            // Create a statement
            statement = connection.createStatement();

            // Execute the SELECT query
            String query = "SELECT * FROM test_table";
            resultSet = statement.executeQuery(query);

            // Get metadata for column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Display column names
            System.out.println("Results:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Display rows
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}