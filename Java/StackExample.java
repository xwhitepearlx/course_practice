import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Create a Stack of Integers
        Stack<Integer> plateStack = new Stack<>();

        // 1. Pushing elements (adding to the top)
        plateStack.push(5);
        plateStack.push(10);
        plateStack.push(15);
        System.out.println("Stack after pushes: " + plateStack); // [5, 10, 15]

        // 2. Peeking at the top element (just looking)
        int topElement = plateStack.peek();
        System.out.println("Element at the top (peek): " + topElement); // 15
        System.out.println("Stack after peek: " + plateStack); // [5, 10, 15] (unchanged)

        // 3. Popping elements (removing from the top)
        int removedElement = plateStack.pop();
        System.out.println("Popped element: " + removedElement); // 15
        System.out.println("Stack after pop: " + plateStack); // [5, 10]

        removedElement = plateStack.pop();
        System.out.println("Popped element: " + removedElement); // 10
        System.out.println("Stack after pop: " + plateStack); // [5]

        // 4. Check if stack is empty
        System.out.println("Is the stack empty? " + plateStack.isEmpty()); // false

        plateStack.pop();
        System.out.println("Is the stack empty now? " + plateStack.isEmpty()); // true

        // 5. Trying to pop from an empty stack throws EmptyStackException
        // plateStack.pop(); // UNCOMMENTING THIS LINE WOULD CRASH THE PROGRAM
    }
}