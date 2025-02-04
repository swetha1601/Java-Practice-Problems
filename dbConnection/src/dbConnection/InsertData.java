package dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
	public static void insertEmployee(String name,int age, float salary) {
		String insertQuery = "INSERT INTO EMPLOYEES(name,age,salary) VALUES(?,?,?)";
		  
		
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(insertQuery)){
			
			
			
			stmt.setString(1,name);
			stmt.setInt(2,age);
			stmt.setFloat(3,salary);
			
			int rowsAffected = stmt.executeUpdate();
			System.out.println("Inserted "+ rowsAffected+"rows into employees table");
			
			
			
		}catch(SQLException e) {
			System.out.println("Error inserting data:"+ e.getMessage());
		}
	}
	
	
	
	

}
