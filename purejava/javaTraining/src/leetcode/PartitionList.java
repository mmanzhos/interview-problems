package leetcode;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(-1);
        
        ListNode first = node1;
        ListNode second = node2;
        
        while (head != null) {
            if (head.val < x) {
                first.next = head;
                first = first.next;
            } else {
                second.next = head;
                second = second.next;
            }
            
            head = head.next;
        }
        
        second.next = null;
        first.next = node2.next;
        
        
        return node1.next;
    }
	
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		ListNode headConst = head;
		
		head.next = new ListNode(2);
		head = head.next;
		
		head.next = new ListNode(4);
		head = head.next;
		
		head.next = new ListNode(3);
		head = head.next;
		
		head.next = new ListNode(5);
		head = head.next;
		
		head.next = new ListNode(2);
		
		PartitionList pl = new PartitionList();
		pl.partition(headConst, 3);
		
	}

}
