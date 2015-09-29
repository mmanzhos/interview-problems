package leetcode;

import leetcode.MergeTwoSortedLists.ListNode;



public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        // return reverseListRec(null, head);
        return prev;
    }
    
    private ListNode reverseListRec(ListNode newHead, ListNode head) {
        if (head == null) return head;
        ListNode tmp = head.next;
        head.next = newHead;
        return reverseListRec(head, tmp);
    }

}
