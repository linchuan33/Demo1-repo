import java.io.*;
import java.util.Random;

public class Assignment6 {

    // Given arrayLength as argument, create an array of random integers between 0 and 100; return the created array.
    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(101); // generates random integer between 0 and 100
        }
        return array;
    }

    // Given an integer array and filename, write the array to the file, with each line containing one integer in the array.
    public static void writeArrayToFile(int[] array, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int value : array) {
                writer.println(value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // This is the reverse of writeArrayToFile; Given the filename, read the integers (one line per integer) to an array, and return the array
    public static int[] readFileToArray(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int count = 0;
            while (reader.readLine() != null) {
                count++;
            }
            int[] array = new int[count];
            reader = new BufferedReader(new FileReader(filename));
            int i = 0;
            while ((line = reader.readLine()) != null) {
                array[i] = Integer.parseInt(line);
                i++;
            }
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return new int[0];
        }
    }

    // Given an integer array, sort it in-place, i.e., the order of the elements will be changed so that the final array is in sorted order.
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // The main function will handle a user's keyboard input specified in the next session
    public static void main(String[] args) {
        // Your implementation for the main method goes here
    }
}
