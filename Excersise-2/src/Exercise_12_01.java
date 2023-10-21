public class Exercise_12_01 {
    public static void main(String[] args) {
        int[] array = {2, 7, 5, 6, 7, 1, 6, 2, 1, 7};

        int mostFrequentNumber = 0;
        int maxFrequency = 0;

        for (int i = 0; i < array.length; i++) {
            int count = 0;

            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }

            if (count > maxFrequency) {
                mostFrequentNumber = array[i];
                maxFrequency = count;
            }
        }

        System.out.println("The most frequently occurring number is " + mostFrequentNumber + " with a frequency of " + maxFrequency);
    }
}
