package dbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MySQLConnection {
	
	        // Database URL, username, and password
	         private static final String url = "jdbc:mysql://localhost:3306/sample";
	         private static final String user = "root";  
	         private static final String PASSWORD = "Incedo@1234";
	        try {
	            // Load the MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establish the connection
	            Connection connection = DriverManager.getConnection(url, user, PASSWORD);

	            // If connected successfully, print message
	            System.out.println("Connected to the database!");

	            
	            connection.close();
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}



