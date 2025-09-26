/*
Example 2: Climbing Stairs (A Classic DP Problem)
Problem: You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Analysis:

Optimal Substructure: The way to reach step n is either by taking a single step from step n-1 or by taking a double step from step n-2. So, the number of ways to reach step n is the sum of the ways to reach step n-1 and step n-2.

Overlapping Subproblems: To calculate ways(n), we need ways(n-1) and ways(n-2). To calculate ways(n-1), we need ways(n-2) and ways(n-3). Notice ways(n-2) is needed multiple times.

This leads to the recurrence relation:
dp[n] = dp[n-1] + dp[n-2] 
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        // Create a DP array. dp[i] represents distinct ways to reach step i.
        int[] dp = new int[n + 1];

        // Base cases:
        dp[0] = 1; // 1 way to be at the start (stand on the ground)
        dp[1] = 1; // 1 way: climb 1 step from step 0.

        // Fill the DP table from step 2 to step n
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Optimized version: We only need the last two values, not the whole array.
    // This uses O(1) space instead of O(n).
    public static int climbStairsOptimized(int n) {
        if (n <= 2) {
            return n;
        }
        int oneStepBack = 2; // ways to get to step 2
        int twoStepsBack = 1; // ways to get to step 1
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = oneStepBack + twoStepsBack;
            // Shift the pointers for the next iteration
            twoStepsBack = oneStepBack;
            oneStepBack = current;
        }
        return current;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Distinct ways to climb " + n + " steps: " + climbStairs(n));
        System.out.println("Distinct ways to climb " + n + " steps: " + climbStairsOptimized(n));
        // Output: Distinct ways to climb 5 steps: 8
        // Explanation: 
        // 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 1+2+2, 2+1+2, 2+2+1
    }
}
