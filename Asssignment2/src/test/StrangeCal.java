package test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;


public class StrangeCal {
	public double sum(double... numbers) {
        double result = 0;
        for (double num : numbers) {
            result += num;
        }
        return result;
    }

    // Method to subtract the second number from the first
    public double subtract(double first, double second) {
        return first - second;
    }

    // Method to multiply an unspecified number of numbers
    public double multiply(double... numbers) {
        double result = 1;
        for (double num : numbers) {
            result *= num;
        }
        return result;
    }

    // Method to divide the first number by the second
    public double divide(double first, double second) {
        if (second == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return first / second;
    }

    // Method to return the remainder of the division (modulus)
    public double modulus(double first, double second) {
        if (second == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return first % second;
    }

    // Method to return the largest number
    public double max(double... numbers) {
        double max = numbers[0];
        for (double num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Method to return the smallest number
    public double min(double... numbers) {
        double min = numbers[0];
        for (double num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Method to return the average of the numbers
    public double average(double... numbers) {
        double sum = sum(numbers);
        return sum / numbers.length;
    }
}

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton sumButton, subtractButton, multiplyButton, divideButton, modulusButton;
    private JButton maxButton, minButton, averageButton, clearButton;
    private JTextArea resultArea;
    private StrangeCalc calc;

    public CalculatorGUI() {
        // Set up the frame
        setTitle("Strange Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        calc = new StrangeCalc();

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputField = new JTextField(30);
        inputPanel.add(new JLabel("Enter numbers separated by spaces:"));
        inputPanel.add(inputField);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        sumButton = new JButton("Sum");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");
        modulusButton = new JButton("Modulus");
        maxButton = new JButton("Max");
        minButton = new JButton("Min");
        averageButton = new JButton("Average");
        clearButton = new JButton("Clear");

        sumButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        modulusButton.addActionListener(this);
        maxButton.addActionListener(this);
        minButton.addActionListener(this);
        averageButton.addActionListener(this);
        clearButton.addActionListener(this);

        buttonPanel.add(sumButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(modulusButton);
        buttonPanel.add(maxButton);
        buttonPanel.add(minButton);
        buttonPanel.add(averageButton);
        buttonPanel.add(clearButton);

        // Result area
        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        String inputText = inputField.getText();

        // Split the input into an array of numbers
        String[] tokens = inputText.split("\\s+");
        List<Double> numbers = new ArrayList<>();
        try {
            for (String token : tokens) {
                numbers.add(Double.parseDouble(token));
            }
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter numbers separated by spaces.");
            return;
        }

        double[] numArray = numbers.stream().mapToDouble(Double::doubleValue).toArray();
        String resultText = "";

        switch (actionCommand) {
            case "Sum":
                resultText = "Sum: " + calc.sum(numArray);
                break;
            case "Subtract":
                if (numArray.length < 2) {
                    resultText = "Please enter at least two numbers.";
                } else {
                    resultText = "Result: " + calc.subtract(numArray[0], numArray[1]);
                }
                break;
            case "Multiply":
                resultText = "Product: " + calc.multiply(numArray);
                break;
            case "Divide":
                if (numArray.length < 2) {
                    resultText = "Please enter at least two numbers.";
                } else {
                    try {
                        resultText = "Division: " + calc.divide(numArray[0], numArray[1]);
                    } catch (IllegalArgumentException ex) {
                        resultText = ex.getMessage();
                    }
                }
                break;
            case "Modulus":
                if (numArray.length < 2) {
                    resultText = "Please enter at least two numbers.";
                } else {
                    try {
                        resultText = "Modulus: " + calc.modulus(numArray[0], numArray[1]);
                    } catch (IllegalArgumentException ex) {
                        resultText = ex.getMessage();
                    }
                }
                break;
            case "Max":
                resultText = "Max: " + calc.max(numArray);
                break;
            case "Min":
                resultText = "Min: " + calc.min(numArray);
                break;
            case "Average":
                resultText = "Average: " + calc.average(numArray);
                break;
            case "Clear":
                inputField.setText("");
                resultArea.setText("");
                return;
            default:
                resultText = "Unknown action.";
        }

        resultArea.setText(resultText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI gui = new CalculatorGUI();
            gui.setVisible(true);
        });
    }
	

}
