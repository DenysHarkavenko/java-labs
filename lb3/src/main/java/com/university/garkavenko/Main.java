package com.university.garkavenko;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double num1 = 0, num2 = 0;
        String operation = "";

        try {
            System.out.print("Enter first number: ");
            num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter second number: ");
            num2 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter operation (+, -, *, /): ");
            operation = scanner.nextLine();

            double result = 0;

            switch (operation) {
                case "+":
                    result = calculator.add(num1, num2);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    break;
                default:
                    throw new InvalidInputException("Invalid operation entered.");
            }

            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Processing complete.");
            scanner.close();
        }
    }
}
