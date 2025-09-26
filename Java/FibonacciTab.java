
public class FibonacciTab {

    public static int fibTab(int n) {
        if (n <= 1) {
            return n;
        }

        // Create a DP table (an array) to store solutions to subproblems
        // dp[i] will represent the i-th Fibonacci number
        int[] dp = new int[n + 1];

        // Initialize the known smallest subproblems (the base cases)
        dp[0] = 0;
        dp[1] = 1;

        // Solve larger subproblems in order, using the solutions to smaller ones
        for (int i = 2; i <= n; i++) {
            // The recurrence relation: the solution to the bigger problem
            // is built from the solutions of smaller problems.
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // The answer to the original problem is in the last cell
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("The "+ n + "-th Fibonacci number is: " + fibTab(n));
    }
}
