import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the temperature in Celsius
        System.out.print("Enter temperature in Celsius: ");

        // Read the temperature in Celsius from the user
        double celsius = scanner.nextDouble();

        // Close the scanner to prevent resource leak
        scanner.close();

        // Convert Celsius to Fahrenheit using the formula: F = (C * 9/5) + 32
        double fahrenheit = (celsius * 9 / 5) + 32;

        // Display the result
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);
    }
}
