/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseLinkedList(slow);
        slow.next = null;
        slow = head;
        mergeLinkedList(slow, fast);
      
        
    }

     public static void mergeLinkedList (ListNode l1  , ListNode l2 ){
        while ( l2 != null && l1 != null){
             
            ListNode l1_next = l1.next ;
            ListNode l2_next = l2.next ;
            l1.next = l2;
            
            l2.next = l1_next;
            
            l1 = l1_next;
            l2 = l2_next;
        }
     }
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