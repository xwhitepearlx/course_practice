// Class representing a single node in the BST
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTreeExample {

    // The root of the BST
    TreeNode root;

    // Constructor for an empty BST
    public BinarySearchTreeExample() {
        root = null;
    }

    // Public method to insert a new value (users call this)
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // Recursive helper method to insert at a given subtree
    private TreeNode insertRecursive(TreeNode current, int value) {
        // Base case: if the subtree is empty, place the new node here
        if (current == null) {
            return new TreeNode(value);
        }

        // Recursive case: navigate down the tree
        if (value < current.data) {
            // Insert into the left subtree
            current.left = insertRecursive(current.left, value);
        } else if (value > current.data) {
            // Insert into the right subtree
            current.right = insertRecursive(current.right, value);
        }
        // If value == current.data, you can decide to allow duplicates or not.
        // Here, we will just ignore duplicates.

        return current; // Return the (unchanged) node pointer
    }

    // Public method to start an in-order traversal
    public void printInOrder() {
        printInOrderRecursive(root);
        System.out.println(); // Print a new line at the end
    }

    // Recursive helper for in-order traversal (Left -> Root -> Right)
    private void printInOrderRecursive(TreeNode node) {
        if (node != null) {
            printInOrderRecursive(node.left);   // 1. Traverse left subtree
            System.out.print(node.data + " "); // 2. Visit the root (print it)
            printInOrderRecursive(node.right);  // 3. Traverse right subtree
        }
    }

    // Main method to demonstrate the BST
    public static void main(String[] args) {
        BinarySearchTreeExample bst = new BinarySearchTreeExample();

        // Let's build the BST from the valid example above
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);

        System.out.println("In-order traversal of the BST:");
        bst.printInOrder(); // The output will be sorted: 1 3 4 6 7 8 10 13 14

        // Let's demonstrate the BST property by searching
        System.out.println("\nThe BST is built with this structure (approximately):");
        System.out.println("        8");
        System.out.println("       / \\");
        System.out.println("      3   10");
        System.out.println("     / \\    \\");
        System.out.println("    1   6    14");
        System.out.println("       / \\   /");
        System.out.println("      4   7 13");
    }
}