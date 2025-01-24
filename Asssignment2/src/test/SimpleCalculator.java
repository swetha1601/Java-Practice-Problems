package test;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class SimpleCalculator extends JFrame implements ActionListener {
    // Define components
    final private TextField display;
    private String currentInput = "";
    private double firstNumber, secondNumber, result;
    private char operator;

    // Constructor to set up the GUI
    public SimpleCalculator() {
        // Frame setup
        setTitle("Simple Calculator");
        setSize(400, 500);
        setLayout(null);
        setVisible(true);

        // Display field setup
        display = new TextField();
        display.setBounds(50, 50, 300, 50);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display);

        // Buttons setup
        String[] buttonLabels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "C", "0", "=", "/"
        };

        // Create buttons and add listeners
        int xPos = 50, yPos = 150;
        for (int i = 0; i < buttonLabels.length; i++) {
            Button button = new Button(buttonLabels[i]);
            button.setBounds(xPos, yPos, 60, 60);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            add(button);

            // Arrange buttons in a grid layout
            xPos += 80;
            if ((i + 1) % 4 == 0) {
                xPos = 50;
                yPos += 80;
            }
        }

        // Add Window Listener to close the app on window close
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();

        if (buttonText.equals("C")) {
            currentInput = "";
            display.setText(currentInput);
        } else if (buttonText.equals("=")) {
            secondNumber = Double.parseDouble(currentInput);
            switch (operator) {
                case '+': result = firstNumber + secondNumber; break;
                case '-': result = firstNumber - secondNumber; break;
                case '*': result = firstNumber * secondNumber; break;
                case '/': result = firstNumber / secondNumber; break;
            }
            currentInput = String.valueOf(result);
            display.setText(currentInput);
        } else if (buttonText.equals("/") || buttonText.equals("*") ||
                   buttonText.equals("-") || buttonText.equals("+")) {
            firstNumber = Double.parseDouble(currentInput);
            operator = buttonText.charAt(0);
            currentInput = "";
        } else {
            currentInput += buttonText;
            display.setText(currentInput);
        }
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        new SimpleCalculator();
    }
}