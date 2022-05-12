public class ReverseLinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        if (head.next == null) {
            return head;

        }
        ListNode lastNode = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return lastNode;

    }  
}
