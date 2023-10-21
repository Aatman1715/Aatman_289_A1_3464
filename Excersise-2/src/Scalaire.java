import java.util.Scanner;

public class Scalaire {
    public static void main(String[] args) {
        int nMax = 10;
        double[] v1 = new double[nMax];
        double[] v2 = new double[nMax];

        Scanner scanner = new Scanner(System.in);

        int n;
        do {
            System.out.print("Enter the effective size of the vectors (between 1 and " + nMax + "): ");
            n = scanner.nextInt();
        } while (n < 1 || n > nMax);

        System.out.println("Enter the components of vector v1:");
        for (int i = 0; i < n; i++) {
            System.out.print("v1[" + i + "]: ");
            v1[i] = scanner.nextDouble();
        }

        System.out.println("Enter the components of vector v2:");
        for (int i = 0; i < n; i++) {
            System.out.print("v2[" + i + "]: ");
            v2[i] = scanner.nextDouble();
        }

        double dotProduct = calculateScalarProduct(v1, v2, n);
        System.out.println("The scalar product of v1 and v2 is: " + dotProduct);
    }

    public static double calculateScalarProduct(double[] v1, double[] v2, int n) {
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += v1[i] * v2[i];
        }
        return result;
    }
}
