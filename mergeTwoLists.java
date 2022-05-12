public class mergeTwoLists {
    
    public static class ListNode {
        int val;
         ListNode next;
    
         ListNode() {
         }
    
         ListNode(int val) {
             this.val = val;
         }
    
         ListNode(int val, ListNode next) {
             this.val = val;
             this.next = next;
         }
     }


    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {

            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }


    public ListNode mergeTwoListsIteration(ListNode list1, ListNode list2) {

        ListNode temp_node = new ListNode(0);
        ListNode outPutNode = temp_node;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                outPutNode.next = list1;
                list1 = list1.next;

            } else {

                outPutNode.next = list2;
                list2 = list2.next;
            }
            outPutNode = outPutNode.next;

        }
        if (list1 == null) {
            outPutNode.next = list2;
        }
        if (list2 == null) {
            outPutNode.next = list1;
        }

        return temp_node.next;

    }


}
