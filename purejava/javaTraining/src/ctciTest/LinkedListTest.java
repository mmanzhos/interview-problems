package ctciTest;

class LinkedListNode {
	int val;
	LinkedListNode next;
	public LinkedListNode(int val) {
		this.val = val;
	}
}

public class LinkedListTest {

	
	public void removeDuplicates(LinkedListNode head) {
		if (head == null) return;
		while (head != null && head.next != null) {
			LinkedListNode current = head;
			while (current.next != null) {
				if (head.val == current.next.val) {
					current.next = current.next.next;
				} else {
					current = current.next;
				}
			}
			head = head.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(1);
		head.next = new LinkedListNode(2);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(3);
		head.next.next.next.next = new LinkedListNode(3);
		head.next.next.next.next.next = new LinkedListNode(3);
		
		LinkedListTest test = new LinkedListTest();
		test.removeDuplicates(head);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		
	}

}
