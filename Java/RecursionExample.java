public class RecursionExample {

    public static int factorial(int n) {
        // 1. Base Case: The simplest problem we can solve immediately.
        if (n == 0 || n == 1) {
            return 1;
        }
        // 2. Recursive Case: The function calls itself with a smaller argument (n-1).
        //    We assume the recursive call correctly gives us the answer to the smaller problem (factorial(n-1)).
        //    We then combine that result with the current step (multiply by n).
        else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println("The factorial of " + number + " is: " + result);
        // Output: The factorial of 5 is: 120
    }
}