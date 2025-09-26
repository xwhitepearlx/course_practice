class ListNode {
    int val;
    ListNode next;
    ListNode(int x){ val = x; }
}

public class ReversedLinkedList{
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) { 
            ListNode nextTemp = curr.next;  // 1. Save next
            curr.next = prev;               // 2. Reverse pointer
            prev = curr;                    // 3. Move prev forward
            curr = nextTemp;                // 4. Move curr forward
        }
        return prev;
    }
    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Original list: ");
        printList(head);

        // Reverse
        head = reverseList(head);

        System.out.print("Reverse List: ");
        printList(head);
    }
}