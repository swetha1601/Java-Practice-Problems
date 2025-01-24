package test;
import java.util.*;

class ReportCard {
    private String name;
    private String surname;
    private String studentClass;
    private Map<String, String> subjects;

    public ReportCard(String name, String surname, String studentClass) {
        this.name = name;
        this.surname = surname;
        this.studentClass = studentClass;
        this.subjects = new HashMap<>();
    }

    public void addSubject(String subject, String grade) {
        String judgement = getJudgement(grade);
        subjects.put(subject, "Grade: " + grade + " || Judgement: " + judgement);
    }

    private String getJudgement(String grade) {
        switch (grade.toUpperCase()) {
            case "A": return "Excellent";
            case "B": return "Good";
            case "C": return "Better";
            case "D": return "Bad";
            case "E": return "Needs Improvement";
            case "F": return "Fail";
            default: return "Invalid Grade";
        }
    }

    public void displayReportCard() {
        System.out.println("Report card for " + name + " " + surname);
        System.out.println(" Class: " + studentClass);
        System.out.println("---------------------------");

        for (Map.Entry<String, String> entry : subjects.entrySet()) {
            String value = entry.getValue();  
            
            
            String[] parts = value.split(" \\|\\| ");  // Split by " || " to separate grade and judgement
            if (parts.length == 2) {
                String grade = parts[0].split(": ")[1]; // Extracting the grade
                String judgement = parts[1].split(": ")[1]; // Extracting the judgement
                
                System.out.println("Subject: " + entry.getKey());
                System.out.println("Grade: " + grade);
                System.out.println("Judgement: " + judgement);
                System.out.println("---------------------------------");
            } else {
                System.out.println("Invalid format for entry: " + entry.getKey());
                System.out.println("Report might have formatting errors in grade or judgement.");
                System.out.println("---------------------------------");
            }
        }
    }
}

class ReportCardPrinter {
    public void printReportCard(ReportCard reportCard) {
        reportCard.displayReportCard();
    }
}

public class ReportCardApp {
    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println("Report Card");
        System.out.println("----------------------------------");
        Scanner input = new Scanner(System.in);

        boolean continueFlag = true;  // Flag to control the loop

        while (continueFlag) {
            System.out.println("Enter the name of Student: ");
            String name = input.nextLine();
            System.out.println("Enter the surname: ");
            String surname = input.nextLine();
            System.out.println("Enter the Class: ");
            String studentClass = input.nextLine();

            ReportCard studentReportCard = new ReportCard(name, surname, studentClass);

            // Take user input for subjects and grades
            System.out.print("Enter number of subjects: ");
            int numSubjects = Integer.parseInt(input.nextLine());

            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter subject " + (i + 1) + ": ");
                String subject = input.nextLine();
                System.out.print("Enter grade for " + subject + ": ");
                String grade = input.nextLine().toUpperCase();

                // Add subject and grade to report card
                studentReportCard.addSubject(subject, grade);
            }

            // Create ReportCardPrinter and print the report card
            ReportCardPrinter printer = new ReportCardPrinter();
            printer.printReportCard(studentReportCard);

            // Ask user if they want to continue or exit
            System.out.print("Do you want to enter another report card? (yes/no): ");
            String response = input.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                continueFlag = false;  
            }
            System.out.println(); 
        }

        input.close();  
    }
}
