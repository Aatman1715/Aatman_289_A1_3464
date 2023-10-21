public class Exercise_8 {
    public static void main(String[] args) {
        // Define the range of numbers for the table
        int start = 2;
        int end = 10;

        // Loop through the range of numbers
        for (int i = start; i <= end; i++) {
            System.out.println("Multiplication table for " + i + ":");

            // Inner loop to calculate and print the multiplication table
            for (int j = 1; j <= 10; j++) {
                int result = i * j;
                System.out.println(i + " * " + j + " = " + result);
            }

            System.out.println(); // Add a newline for separation
        }
    }
}