package leetcode;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}


public class PopulatingNextRightPointer {
    
    /*
    No go without pseduo code and thoughts.
    1. Make prev level variable
    2. Make next level variable
    4. nextLevel.left.next = nextLevel.right
    5. nextLevel.right.next = prevLevel.next.left
    
    */
    
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode head = root;
        TreeLinkNode prev = null;
        TreeLinkNode curr = null;
        
        // iterate over each level
        while (head != null) {
            curr = head;
            prev = null;
            head = null;
            
            // iterate over each node on upper level, meanwhile creating lower level next pointers
            while (curr != null) {
                if (curr.left != null) {
                    if (prev == null) {
                        prev = curr.left;
                        head = curr.left;
                    } else {
                        prev.next = curr.left;
                        prev = curr.left;
                    }
                }
                
                if (curr.right != null) {
                    if (prev == null) {
                        prev = curr.right;
                        head = curr.right;
                    } else {
                        prev.next = curr.right;
                        prev = curr.right;
                    }
                }
                
                
                curr = curr.next;
            }            
            
        }
        
    }
}