package vehicle;
import java.sql.Connection;


public class bookingHistory {
	
	
	
	
	    // Database credentials
	    private static final String URL = "jdbc:mysql://localhost:3306/VehicleRental";
	    private static final String USER = "root"; // Change if needed
	    private static final String PASSWORD = "Incedo@1234"; // Change if needed

	    public static void main(String[] args) {
	        String vehicleId = "V123"; // Replace with actual vehicle ID

	        // SQL query to fetch booking history for a vehicle
	        String query = "SELECT b.id AS booking_id, u.name AS user_name, b.booking_time, b.booking_price, b.duration, p.payment_status " +
	                       "FROM bookings b " +
	                       "JOIN users u ON b.user_id = u.id " +
	                       "LEFT JOIN payments p ON b.payment_id = p.id " +
	                       "WHERE b.vehicle_id = ? " +
	                       "ORDER BY b.booking_time DESC";

	        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	             PreparedStatement stmt = conn.prepareStatement(query)) {

	            stmt.setString(1, vehicleId);
	            ResultSet rs = stmt.executeQuery();

	            System.out.println("Booking History for Vehicle ID: " + vehicleId);
	            System.out.println("-----------------------------------------------------");
	            while (rs.next()) {
	                System.out.println("Booking ID: " + rs.getString("booking_id"));
	                System.out.println("User Name: " + rs.getString("user_name"));
	                System.out.println("Booking Time: " + rs.getTimestamp("booking_time"));
	                System.out.println("Booking Price: $" + rs.getDouble("booking_price"));
	                System.out.println("Duration: " + rs.getString("duration"));
	                System.out.println("Payment Status: " + rs.getString("payment_status"));
	                System.out.println("-----------------------------------------------------");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


}
