
import java.util.Arrays;

public class BubbleSortExample {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // This loop controls the number of passes
        for (int i = 0; i < n - 1; i++) {
            // This loop does the adjacent comparisons
            // The -i is because the last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap them if they are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // Optional: Print the array after each pass to see the progress
            System.out.println("After pass " + (i+1) + ": " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(numbers));

        bubbleSort(numbers);

        System.out.println("Sorted array: " + Arrays.toString(numbers));
        // Output: Sorted array: [11, 12, 22, 25, 34, 64, 90]
    }
}