import java.util.Scanner;

public class Exercise_12_02 {
    public static void main(String[] args) {
        final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        final int SHIFT = 3;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string of characters:");
        String input = scanner.nextLine().toLowerCase();  // Convert input to lowercase

        // Filter and construct the toEncode string
        String toEncode = "";
        for (char c : input.toCharArray()) {
            if (c == ' ' || ALPHABET.contains(String.valueOf(c))) {
                toEncode += c;
            }
        }

        System.out.println("The initial chain was: '" + input + "'");
        System.out.println("The string to encode is: '" + toEncode + "'");

        if (toEncode.isEmpty()) {
            System.out.println("The string to encode is empty.");
        } else {
            // Encode the toEncode string using Caesar cipher
            String encoded = encodeCaesarCipher(toEncode, SHIFT, ALPHABET);
            System.out.println("The coded string is: '" + encoded + "'");
        }
    }

    public static String encodeCaesarCipher(String toEncode, int shift, String ALPHABET) {
        StringBuilder encoded = new StringBuilder();

        for (char c : toEncode.toCharArray()) {
            if (c == ' ') {
                encoded.append(' ');
            } else {
                int index = (ALPHABET.indexOf(c) + shift) % ALPHABET.length();
                encoded.append(ALPHABET.charAt(index));
            }
        }

        return encoded.toString();
    }
}
