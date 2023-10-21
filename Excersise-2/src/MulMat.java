import java.util.Scanner;

public class MulMat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read dimensions and elements of the first matrix (mat1)
        System.out.println("Entering the 1st matrix:");
        int rows1 = readDimension("Number of rows: ", scanner);
        int cols1 = readDimension("Number of columns: ", scanner);
        double[][] mat1 = readMatrix(rows1, cols1, scanner);

        // Read dimensions and elements of the second matrix (mat2)
        System.out.println("Entering the 2nd matrix:");
        int rows2 = readDimension("Number of rows: ", scanner);
        int cols2 = readDimension("Number of columns: ", scanner);
        double[][] mat2 = readMatrix(rows2, cols2, scanner);

        // Check if multiplication is possible
        if (cols1 != rows2) {
            System.out.println("Multiplication of matrices is impossible!");
            return;
        }

        // Perform matrix multiplication and store the result in prod
        double[][] prod = multiplyMatrices(mat1, mat2);

        // Display the result matrix
        System.out.println("Result:");
        displayMatrix(prod);
    }

    public static int readDimension(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static double[][] readMatrix(int rows, int cols, Scanner scanner) {
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("M[" + (i + 1) + "," + (j + 1) + "] = ");
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    public static double[][] multiplyMatrices(double[][] mat1, double[][] mat2) {
        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int rows2 = mat2.length;
        int cols2 = mat2[0].length;

        double[][] result = new double[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    public static void displayMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
