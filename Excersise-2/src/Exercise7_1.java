import java.util.Scanner;

public class Exercise7_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter integer #" + i + ": ");
            int number = scanner.nextInt();
            sum += number;
        }
        double average = (double) sum / 10;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
