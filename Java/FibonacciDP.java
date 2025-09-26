import java.util.Arrays;

public class FibonacciDP {
    // Array to act as our memo/cache
    private static int[] memo;

    public static int fibMemo(int n) {
        // Initialize memo with -1 (meaning 'not calculated yet')
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibHelper(n);
    }

    private static int fibHelper(int n) {
        // 1. Base Case
        if (n <= 1) return n;

        // 2. Check the memo FIRST. If we already solved this subproblem, return the saved answer.
        if (memo[n] != -1) {
            return memo[n];
        }

        // 3. If not in memo, calculate it recursively and SAVE the result in the memo before returning.
        memo[n] = fibHelper(n - 1) + fibHelper(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("The " + n + "-th Fibonacci number is: " + fibMemo(n));
        // Output: The 10-th Fibonacci number is: 55
    }
}