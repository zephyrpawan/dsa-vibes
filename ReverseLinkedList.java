public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static ListNode reverse(ListNode head) {
        ListNode reversed = new ListNode();
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = reversed.next;
            reversed.next = current;
            current = next;
        }

        return reversed.next;
    }

    static ListNode reverseRecursive(ListNode head) {
        if(head == null || head.next ==  null) return head;
        ListNode reversedHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two; two.next = three; three.next = four; four.next = five;

        printList(one);
        System.out.println();
        printList(reverse(one));
        System.out.println();
//        printList(reverseRecursive(one));
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
    }

}
