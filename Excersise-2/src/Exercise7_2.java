import java.util.Scanner;
public class Exercise7_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        while (true) {
            System.out.print("Do you want to continue? (Yes/No): ");
            String response = scanner.next();

            if (response.equalsIgnoreCase("No")) {
                break;
            } else if (!response.equalsIgnoreCase("Yes")) {
                System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
                continue;
            }
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();
            sum += number;
            count++;
        }
        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
        } else {
            System.out.println("No numbers were entered.");
        }
    }
}
