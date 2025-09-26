// A class to represent a node in the linked list for separate chaining
class HashNode {
    String key;
    String value;
    HashNode next; // Pointer to the next node in the chain

    public HashNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class SimpleHashTable {

    private HashNode[] buckets; // The array of buckets
    private int numBuckets;     // The size of the array
    private int size;           // The number of key-value pairs in the table

    public SimpleHashTable(int capacity) {
        this.numBuckets = capacity;
        this.buckets = new HashNode[numBuckets];
        this.size = 0;
    }

    // 1. The Hash Function
    private int getBucketIndex(String key) {
        // Use Java's built-in hashCode() method, then map it to our array size.
        // The & 0x7FFFFFFF ensures the hash is non-negative.
        return (key.hashCode() & 0x7FFFFFFF) % numBuckets;
    }

    // 2. Operation: Insert (or Update) a key-value pair
    public void put(String key, String value) {
        if (key == null) {
            // Cannot have a null key
            return;
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        // Check if the key already exists in the chain
        while (head != null) {
            if (head.key.equals(key)) {
                // Key found, update its value
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Key was not found, insert new node at the beginning of the chain
        size++;
        HashNode newNode = new HashNode(key, value);
        newNode.next = buckets[bucketIndex]; // Point new node to the old head
        buckets[bucketIndex] = newNode;      // New node becomes the head

        // Optional: Add logic here to check Load Factor and resize the array if needed.
        // Load Factor = size / numBuckets. If it exceeds 0.7, double the array size and rehash.
    }

    // 3. Operation: Get the value for a given key
    public String get(String key) {
        if (key == null) {
            return null;
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        // Traverse the chain to find the key
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value; // Key found, return the value
            }
            head = head.next;
        }
        return null; // Key not found
    }

    // 4. Operation: Remove a key-value pair
    public String remove(String key) {
        if (key == null) {
            return null;
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode prev = null; // We need the previous node for linked list deletion

        while (head != null) {
            if (head.key.equals(key)) {
                // Key found! Now remove it from the chain.
                size--;
                if (prev != null) {
                    prev.next = head.next; // Bypass the node to be deleted
                } else {
                    buckets[bucketIndex] = head.next; // Deleting the head node
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null; // Key not found
    }

    // 5. Utility method to print the entire hash table
    public void printTable() {
        for (int i = 0; i < numBuckets; i++) {
            System.out.print("Bucket " + i + ": ");
            HashNode head = buckets[i];
            while (head != null) {
                System.out.print("[" + head.key + "=" + head.value + "] -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    // Main method to demonstrate the hash table
    public static void main(String[] args) {
        SimpleHashTable animalSounds = new SimpleHashTable(10); // Create a small table

        // Insert some key-value pairs
        animalSounds.put("dog", "woof");
        animalSounds.put("cat", "meow");
        animalSounds.put("bird", "tweet");
        animalSounds.put("cow", "moo");
        animalSounds.put("lion", "roar");

        // This will cause a collision with "dog" (assuming they hash to the same bucket)
        animalSounds.put("god", "divine");

        System.out.println("The Hash Table structure:");
        animalSounds.printTable();

        System.out.println("\n--- Basic Operations ---");
        // Get a value
        System.out.println("What does a cat say? " + animalSounds.get("cat")); // meow

        // Update a value
        animalSounds.put("bird", "chirp");
        System.out.println("Bird now says: " + animalSounds.get("bird")); // chirp

        // Get a non-existent value
        System.out.println("What does a fox say? " + animalSounds.get("fox")); // null

        // Remove a key
        String removedSound = animalSounds.remove("cow");
        System.out.println("Removed the cow. It said: " + removedSound); // moo
        System.out.println("What does a cow say now? " + animalSounds.get("cow")); // null

        System.out.println("\nFinal Hash Table structure:");
        animalSounds.printTable();
        System.out.println("Total number of elements: " + animalSounds.size);
    }
}