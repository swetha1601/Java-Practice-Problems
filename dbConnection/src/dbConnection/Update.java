package dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	public static void updateData(int id, String newName, int newAge, float newSalary) {
	String query="UPDATE employee SET name name=? , age=?, salary=? where id=?";
	
	try(Connection conn= DBConnection.getConnection();
		PreparedStatement stmt = conn.prepareStatement(query)	){
		
		
		stmt.setString(1,newName);
		stmt.setInt(2,newAge);
		stmt.setFloat(3, newSalary);
		stmt.setInt(4,id);
		
		int rowsupdated= stmt.executeUpdate();
		if(rowsupdated>0) {
			System.out.println("Data uploaded succesfully!");
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	
	
	}

}
