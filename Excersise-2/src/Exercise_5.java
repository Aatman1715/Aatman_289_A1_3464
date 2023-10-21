import java.util.Scanner;
public class Exercise_5 {
    public static void main(String[] args)
    {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = sc.nextInt();
        if (number == 0) {
            System.out.println("The number is zero.");
        } else if (number > 0) {
            if (number % 2 == 0) {
                System.out.println("The number is positive and even.");
            } else {
                System.out.println("The number is positive and odd.");
            }
        } else {
            if (number % 2 == 0) {
                System.out.println("The number is negative and even.");
            } else {
                System.out.println("The number is negative and odd.");
            }
        }
    }
}
