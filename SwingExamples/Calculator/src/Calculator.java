package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 500);

            CalculatorPanel calculatorPanel = new CalculatorPanel();
            frame.add(calculatorPanel);

            frame.setVisible(true);
        });
    }
}

class CalculatorPanel extends JPanel {
    private JTextField display; // Display field for input and results
    private double firstNumber = 0; // First operand
    private String operator = ""; // Current operator (+, -, *, /)
    private boolean isNewInput = true; // Flag to determine if the input is new

    public CalculatorPanel() {
        setLayout(new BorderLayout());

        // Create the display field
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        // Add buttons to the panel
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
                // Handle number buttons
                if (isNewInput) {
                    display.setText(command);
                    isNewInput = false;
                } else {
                    display.setText(display.getText() + command);
                }
            } else if ("+-*/".contains(command)) {
                // Handle operator buttons
                firstNumber = Double.parseDouble(display.getText());
                operator = command;
                isNewInput = true;
            } else if ("=".equals(command)) {
                // Handle equals button
                double secondNumber = Double.parseDouble(display.getText());
                double result = calculate(firstNumber, secondNumber, operator);
                display.setText(Double.toString(result));
                isNewInput = true;
            } else if ("C".equals(command)) {
                // Handle clear button
                display.setText("0");
                firstNumber = 0;
                operator = "";
                isNewInput = true;
            }
        }

        private double calculate(double num1, double num2, String op) {
            switch (op) {
                case "+": return num1 + num2;
                case "-": return num1 - num2;
                case "*": return num1 * num2;
                case "/": return num2 != 0 ? num1 / num2 : 0; // Avoid division by zero
                default: return 0;
            }
        }
    }
}
