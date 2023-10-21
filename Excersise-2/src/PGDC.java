import java.util.Scanner;

public class PGDC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int number1 = input.nextInt();

        while (number1 <= 0) {
            System.out.println("Please enter a positive number.");
            System.out.print("Enter a positive number: ");
            number1 = input.nextInt();
        }

        System.out.print("Enter a positive number: ");
        int number2 = input.nextInt();

        while (number2 <= 0) {
            System.out.println("Please enter a positive number.");
            System.out.print("Enter a positive number: ");
            number2 = input.nextInt();
        }

        int gcd = calculateGCD(number1, number2);

        System.out.println("The largest common divisor of " + number1 + " and " + number2 + " is " + gcd);
    }

    // Euclid's algorithm to calculate GCD
    public static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }
}
