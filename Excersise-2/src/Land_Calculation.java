import java.util.Scanner;

public class Land_Calculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read and validate the land map
        int numRows = 0;
        int numCols = -1;
        String line;
        StringBuilder mapBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            if (line.isEmpty()) {
                break;
            }

            numRows++;
            mapBuilder.append(line);

            if (numCols == -1) {
                numCols = line.length();
            } else if (line.length() != numCols) {
                System.out.println("Your terrain map does not have the correct format.");
                return;
            }
        }

        if (numRows == 0 || numCols == -1) {
            System.out.println("Your terrain map is empty.");
            return;
        }

        String map = mapBuilder.toString();

        // Check row convexity
        if (!isRowConvex(map, numCols)) {
            System.out.println("Your terrain map does not have the correct format: Incoming outer edge found.");
            return;
        }

        // Calculate the length of the fence required
        double fenceLength = calculateFenceLength(map, numCols);

        System.out.println("You need " + fenceLength + " meters of fence for your land.");
    }

    public static double calculateFenceLength(String map, int numCols) {
        double fenceLength = 0;
        char[] mapArray = map.toCharArray();

        for (int i = 0; i < mapArray.length; i++) {
            if (mapArray[i] == '1') {
                // Check if it's on the perimeter
                if (i % numCols == 0 || i % numCols == numCols - 1 || i / numCols == 0 || i / numCols == numCols - 1) {
                    fenceLength += 2.5;
                }
            }
        }

        return fenceLength;
    }

    public static boolean isRowConvex(String map, int numCols) {
        char[] mapArray = map.toCharArray();
        for (int i = 0; i < mapArray.length; i++) {
            if (mapArray[i] == '1') {
                if (i % numCols == 0 || i % numCols == numCols - 1) {
                    // Check if it's on the outer edge
                    if (mapArray[i] == '0') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
