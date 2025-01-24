package test;


import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookApp {

    
    public static class PhoneBook {
        
        
        private ArrayList<Contact> contacts;

        
        public PhoneBook() {
            contacts = new ArrayList<>();
        }

        
        public void addContact(Contact contact) {
            contacts.add(contact);
        }

        // Method to search contacts by name
        public Contact[] searchContactsByName(String name) {
            ArrayList<Contact> resultList = new ArrayList<>();
            
            // Iterate through the contacts and check if the name contains the search string
            for (Contact contact : contacts) {
                if (contact.getName().toLowerCase().contains(name.toLowerCase())) {
                    resultList.add(contact);
                }
            }
            
            // Convert the result list to an array and return
            return resultList.toArray(new Contact[resultList.size()]);
        }

        // Contact class representing each individual contact
        public static class Contact {
            private String name;
            private String phoneNumber;

            // Constructor to initialize the contact
            public Contact(String name, String phoneNumber) {
                this.name = name;
                this.phoneNumber = phoneNumber;
            }

            // Getter for the name
            public String getName() {
                return name;
            }

            // Getter for the phone number
            public String getPhoneNumber() {
                return phoneNumber;
            }

            // Override toString to display the contact information
            @Override
            public String toString() {
                return "Name: " + name + ", Phone Number: " + phoneNumber;
            }
        }
    }

    // Main class for testing the search functionality
    public static void main(String[] args) {
        // Create a PhoneBook instance
        PhoneBook phoneBook = new PhoneBook();

        // Add some contacts to the phone book
        phoneBook.addContact(new PhoneBook.Contact("Swetha", "9849455893"));
        phoneBook.addContact(new PhoneBook.Contact("Abhi", "8977384831"));
        phoneBook.addContact(new PhoneBook.Contact("Swetha sri", "9836499737"));
        phoneBook.addContact(new PhoneBook.Contact("Abhilash Sharma", "7346275544"));
        
        // Create a scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a search term
        System.out.print("Enter a name or part of a name to search for: ");
        String searchTerm = scanner.nextLine().trim();

        // Search for contacts matching the input term
        PhoneBook.Contact[] results = phoneBook.searchContactsByName(searchTerm);

        // Print the search results
        if (results.length > 0) {
            System.out.println("Search results:");
            for (PhoneBook.Contact contact : results) {
                System.out.println(contact);
            }
        } else {
            System.out.println("No contacts found with the name containing: " + searchTerm);
        }

        // Close the scanner
        scanner.close();
    }
}
