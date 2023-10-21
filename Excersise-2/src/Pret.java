import java.util.Scanner;

public class Pret {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input validation for S0 (strictly positive)
        double S0;
        do {
            System.out.print("Enter the initial loan amount (S0, strictly positive): ");
            S0 = scanner.nextDouble();
        } while (S0 <= 0);

        // Input validation for r (strictly positive)
        double r;
        do {
            System.out.print("Enter the fixed monthly repayment (r, strictly positive): ");
            r = scanner.nextDouble();
        } while (r <= 0);

        // Input validation for ir (strictly between 0 and 1)
        double ir;
        do {
            System.out.print("Enter the monthly interest rate (ir, strictly between 0 and 1): ");
            ir = scanner.nextDouble();
        } while (ir <= 0 || ir >= 1);

        int months = 0;
        double totalInterest = 0;

        while (S0 > 0) {
            double monthlyInterest = ir * S0;
            if (S0 <= r) {
                r = S0;
            }
            S0 -= r;
            totalInterest += monthlyInterest;
            months++;
        }

        System.out.println("Total interest received: $" + totalInterest);
        System.out.println("Duration in months: " + months);

        scanner.close();
    }
}
