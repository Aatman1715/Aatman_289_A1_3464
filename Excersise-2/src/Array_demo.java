import java.util.Scanner;
public class Array_demo {
    public static void main(String[] args) {
        int[] arr = {99,78,65,54,87,100};
        int minValue = findMinimum(arr);
        int maxValue = findMaximum(arr);

        System.out.println("Minimum value: " + minValue);
        System.out.println("Maximum value: " + maxValue);
        Scanner sc = new Scanner(System.in);
        System.out.print("True for ascending and False for descending:");
        boolean ascending = sc.nextBoolean();
        sortArray(arr, ascending);

        System.out.print("Sorted Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int findMinimum(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int findMaximum(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void sortArray(int[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else {
                    if (arr[j] < arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }
}
