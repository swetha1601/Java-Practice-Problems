package dbConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Check database connection before proceeding
        if (checkDatabaseConnection()) {
            System.out.println("Successfully connected to the database!");

            // Create the table if it doesn't already exist
            Create.createTable();

            // Show the menu for user input and perform operations
            while (true) {
                System.out.println("\nPlease choose an operation:");
                System.out.println("1. Insert Data");
                System.out.println("2. Read Data");
                System.out.println("3. Update Data");
                System.out.println("4. Delete Data");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = sc.nextInt();
                sc.nextLine();  // Consume the newline left by nextInt
                
                switch (choice) {
                    case 1:
                        // Insert data
                        System.out.println("\nInserting data...");
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        System.out.print("Enter salary: ");
                        float salary = sc.nextFloat();
                        InsertData.insertEmployee(name, age, salary);
                        break;
                        
                    case 2:
                        // Read data
                        System.out.println("\nReading data...");
                        Read.readData();
                        break;
                        
                    case 3:
                        // Update data
                        System.out.print("\nEnter the ID of the employee to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();  // Consume the newline
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new age: ");
                        int newAge = sc.nextInt();
                        System.out.print("Enter new salary: ");
                        float newSalary = sc.nextFloat();
                        Update.updateData(updateId, newName, newAge, newSalary);
                        break;
                        
                    case 4:
                        // Delete data
                        System.out.print("\nEnter the ID of the employee to delete: ");
                        int deleteId = sc.nextInt();
                        Delete.deleteData(deleteId);
                        break;
                        
                    case 5:
                        // Exit the program
                        System.out.println("Exiting program...");
                        sc.close();
                        return;
                        
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Failed to connect to the database. Exiting program...");
        }
    }

    // Method to check database connection
    private static boolean checkDatabaseConnection() {
        try (Connection conn = DBConnection.getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.out.println("Error: Unable to connect to the database.");
            e.printStackTrace();
            return false;
        }
    }
}
