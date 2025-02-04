package dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Delete {
	
	public static void deleteData(int id) {
		String query="DELETE FROM employees WHERE id=?";
		
		
		try(Connection conn=DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query)){
			
			stmt.setInt(1, id);
			
			int rowsDeleted=stmt.executeUpdate();
			
			if(rowsDeleted>0) {
				System.out.println("Data deleted Successfully!");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
