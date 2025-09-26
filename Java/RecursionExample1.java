
public class RecursionExample1 {

    public static int fibonacci(int n) {
        // 1. Base Cases: The first two numbers are defined directly.
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } // 2. Recursive Case: The sum of the two previous Fibonacci numbers.
        //    To calculate the n-th number, we need the (n-1)-th and (n-2)-th numbers.
        else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int position = 7;
        int result = fibonacci(position);
        System.out.println("The Fibonacci number at position " + position + " is: " + result);
        // Output: The Fibonacci number at position 7 is: 13
        // (Sequence: 0, 1, 1, 2, 3, 5, 8, 13)
    }
}
