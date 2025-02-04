package dbConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Vehicle {
	

	
	    private static final String URL = "jdbc:mysql://localhost:3306/VehicleRental"; 
	    private static final String USER = "root";  
	    private static final String PASSWORD ="Incedo@1234"; 

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Ask user for vehicle ID
	        System.out.print("Enter Vehicle ID: ");
	        String vehicleId = scanner.nextLine();

	        // Call function to fetch booking history
	        getBookingHistory(vehicleId);
	        
	        scanner.close();
	    }

	    public static void getBookingHistory(String vehicleId) {
	        String query = "SELECT b.id AS booking_id, u.name AS user_name, b.booking_time, b.booking_price, b.duration, p.payment_status " +
	                       "FROM bookings b " +
	                       "JOIN users u ON b.user_id = u.id " +
	                       "LEFT JOIN payments p ON b.payment_id = p.id " +
	                       "WHERE b.vehicle_id = ?";

	        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	             PreparedStatement stmt = conn.prepareStatement(query)) {

	            // Set the vehicle ID in the query
	            stmt.setString(1, vehicleId);
	            ResultSet rs = stmt.executeQuery();

	            System.out.println("\nBooking History for Vehicle ID: " + vehicleId);
	            System.out.println("---------------------------------------------------");

	            boolean hasRecords = false;
	            while (rs.next()) {
	                hasRecords = true;
	                System.out.println("Booking ID   : " + rs.getString("booking_id"));
	                System.out.println("User Name    : " + rs.getString("user_name"));
	                System.out.println("Booking Time : " + rs.getTimestamp("booking_time"));
	                System.out.println("Price (₹)    : " + rs.getDouble("booking_price"));
	                System.out.println("Duration     : " + rs.getString("duration"));
	                System.out.println("Payment Status: " + rs.getString("payment_status"));
	                System.out.println("---------------------------------------------------");
	            }

	            if (!hasRecords) {
	                System.out.println("❌ No bookings found for the given Vehicle ID.");
	            }

	        } catch (Exception e) {
	            System.out.println("❌ Error fetching booking history: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}


