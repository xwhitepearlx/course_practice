import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Create a Queue of Strings using a LinkedList
        Queue<String> ticketQueue = new LinkedList<>();

        // 1. Enqueuing elements (adding to the rear)
        ticketQueue.add("Alice");
        ticketQueue.add("Bob");
        ticketQueue.add("Charlie");
        // The offer() method is similar to add() but less likely to throw an exception
        ticketQueue.offer("Diana"); 
        System.out.println("Queue after adds: " + ticketQueue); // [Alice, Bob, Charlie, Diana]

        // 2. Peeking at the front element (just looking)
        String frontPerson = ticketQueue.peek();
        System.out.println("Person at the front (peek): " + frontPerson); // Alice
        System.out.println("Queue after peek: " + ticketQueue); // unchanged

        // 3. Dequeuing elements (removing from the front)
        String servedPerson = ticketQueue.remove();
        System.out.println("Served person (remove): " + servedPerson); // Alice
        System.out.println("Queue after remove: " + ticketQueue); // [Bob, Charlie, Diana]

        servedPerson = ticketQueue.poll(); // poll() is similar to remove() but returns null if empty
        System.out.println("Served person (poll): " + servedPerson); // Bob
        System.out.println("Queue after poll: " + ticketQueue); // [Charlie, Diana]

        // 4. Check if queue is empty
        System.out.println("Is the queue empty? " + ticketQueue.isEmpty()); // false

        // Let's serve the remaining people
        ticketQueue.poll(); // Serve Charlie
        ticketQueue.poll(); // Serve Diana
        System.out.println("Is the queue empty now? " + ticketQueue.isEmpty()); // true

        // 5. Peeking/Polling an empty queue
        System.out.println("Peek on empty queue: " + ticketQueue.peek()); // returns null
        System.out.println("Poll on empty queue: " + ticketQueue.poll()); // returns null
        // ticketQueue.remove(); // UNCOMMENTING THIS WOULD THROW A NoSuchElementException
        
    }
}