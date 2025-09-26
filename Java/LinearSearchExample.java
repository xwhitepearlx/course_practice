public class LinearSearchExample {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found, return its index
            }
        }
        return -1; // Target not found in the array
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6};
        int target = 9;

        int result = linearSearch(numbers, target);

        if (result == -1) {
            System.out.println(target + " not found in the array.");
        } else {
            System.out.println(target + " found at index: " + result);
        }
        // Output: 9 found at index: 2
    }
}