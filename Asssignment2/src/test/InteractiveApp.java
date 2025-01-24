package test;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class InteractiveApp {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String string = "";

        // Create a set of words to censor
        Set<String> censoredWords = new HashSet<>();
        censoredWords.add("hate");  // Example of a censored word
        censoredWords.add("die");  // Another censored word
        censoredWords.add("curse");     // Add more words as needed

        System.out.println("Type something then press enter " +
                "or type \"end\" to end the program");

        // Loop until the user types "end"
        while (!(string = input.next()).equals("end")) {
            // Check if the word is in the censored list
            if (censoredWords.contains(string.toLowerCase())) {
                // Replace censored word with asterisks
                string = "****";
            }
            // Output the result
            System.out.println("You typed: " + string);
        }

        System.out.println("Program ended!");
    }
}
