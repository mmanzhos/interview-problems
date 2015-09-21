package ctciTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    ArrayList<TreeNode> children;
    public TreeNode(int val) {
    	this.val = val;
    	children = new ArrayList();
    } 
    public void addChild(TreeNode node) {
    	this.children.add(node);
    }
}

public class PostOrderIter {

	public static List<TreeNode> getPostOrder(TreeNode root){
	    LinkedList<TreeNode> results = new LinkedList<TreeNode>();
	    if(root == null){
	        return results;
	    }

	    Stack<TreeNode> unprocessed = new Stack<TreeNode>();
	    unprocessed.push(root);
	    while(!unprocessed.isEmpty()){
	        TreeNode TreeNode = unprocessed.pop();
	        results.addFirst(TreeNode);
	        for(TreeNode childTreeNode : TreeNode.children){
	            unprocessed.push(childTreeNode);
	        }
	    }
	    return results;
	}
	
	public void dfsPorstorder(TreeNode root) {
        if (root == null) return;

        TreeNode currentNode = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();

        stack.push(new TreeNode(Integer.MIN_VALUE));
        stack.push(root);

        while (!stack.isEmpty()) {
            if (currentNode.val == Integer.MIN_VALUE)
                return;

            TreeNode currentTmp = currentNode;

            boolean foundUnvisited = false;
            for (TreeNode child : currentNode.children) {
                if (!visited.contains(child)) {
                    if (currentNode.val != root.val) {
                        stack.push(currentNode);
                    }
                    currentNode = child;
                    foundUnvisited = true;
                    break;
                }
            }

            if (currentNode.children.size() == 0 || !foundUnvisited) {
                visited.add(currentNode);
                //visit(currentNode);
                System.out.println(currentNode.val);
                currentNode = stack.pop();
            }
        }


    }
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		root.addChild(n2);
		root.addChild(n3);
		
		n2.addChild(n4);
		n2.addChild(n5);
		
		n4.addChild(n6);
		
		PostOrderIter poi = new PostOrderIter();
		poi.dfsPorstorder(root);
		
		System.out.println();
		for (TreeNode n : poi.getPostOrder(root)) {
			System.out.println(n.val);
		}
		
		
		
	}

}
