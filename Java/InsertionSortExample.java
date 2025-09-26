
import java.util.Arrays;

public class InsertionSortExample {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        // Start from the second element (index 1)
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // The element to be positioned
            int j = i - 1;    // Start comparing with the element left of i

            /* Move elements of arr[0..i-1] that are GREATER than key
               one position to the right to make space */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // Place the key in its correct location
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {12, 11, 13, 5, 6};
        System.out.println("Original array: " + Arrays.toString(numbers));

        insertionSort(numbers);

        System.out.println("Sorted array: " + Arrays.toString(numbers));
        // Output: Sorted array: [5, 6, 11, 12, 13]
    }
}