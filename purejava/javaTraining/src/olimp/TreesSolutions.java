package olimp;

import java.util.ArrayList;

public class TreesSolutions {

	public static void main(String[] args) {

		TreeNode<String> root = new TreeNode<String>("A");
		{
			TreeNode<String> node0 = root.addChild("B");
			TreeNode<String> node1 = root.addChild("C");
			{
				TreeNode<String> node00 = node0.addChild("D");
				TreeNode<String> node10 = node1.addChild("E");
				TreeNode<String> node11 = node1.addChild("F");
				{
					TreeNode<String> node100 = node10.addChild("G");
				}
			}
		}
		
		TreeNode<String> root1 = new TreeNode<String>("A");
		{
			TreeNode<String> node0 = root1.addLeft("B");
			TreeNode<String> node1 = root1.addRight("C");
			{
				TreeNode<String> node00 = node0.addLeft("D");
				TreeNode<String> node10 = node1.addLeft("E");
				{
					TreeNode<String> node100 = node10.addLeft("G");
				}
			}
		}

		root.print();
		System.out.println(root.isBalanced(root));
		
		root1.print2();
		System.out.println(root1.isBalanced(root));
	}

}

class TreeNode<T> {
	T data;
	TreeNode<T> parent;
	ArrayList<TreeNode<T>> children;
	
	TreeNode left;
	TreeNode right;

	public TreeNode(T data) {
		this.data = data;
		this.children = new ArrayList<TreeNode<T>>();
	}

	public TreeNode<T> addChild(T child) {
		TreeNode<T> childNode = new TreeNode<T>(child);
		childNode.parent = this;
		this.children.add(childNode);
		return childNode;
	}
	
	public TreeNode<T> addLeft(T child) {
		TreeNode<T> childNode = new TreeNode<T>(child);
		childNode.parent = this;
		this.left = childNode;
		return childNode;
	}
	public TreeNode<T> addRight(T child) {
		TreeNode<T> childNode = new TreeNode<T>(child);
		childNode.parent = this;
		this.right = childNode;
		return childNode;
	}

	/*
	 * public void printTree(){ LinkedList<TreeNode<T>> list = this.children;
	 * LinkedListNode head = list.head; while( head.next != null ){
	 * System.out.println(); head = head.next; } }
	 */

	public void print() {
		print("", true);
	}
	
	public void print2() {
		print2("", true);
	}

	private void print(String prefix, boolean isTail) {
		System.out.println(prefix + (isTail ? "└── " : "├── ") + data);
		for (int i = 0; i < children.size() - 1; i++) {
			children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
		}
		if (children.size() > 0) {
			children.get(children.size() - 1).print(
					prefix + (isTail ? "    " : "│   "), true);
		}
	}
	
	private void print2(String prefix, boolean isTail) {
		System.out.println(prefix + (isTail ? "└── " : "├── ") + data);
		//for (int i = 0; i < children.size() - 1; i++) {
		if(left != null && right !=null) left.print2(prefix + (isTail ? "    " : "│   "), false);
		if(left != null && right ==null) left.print2(prefix + (isTail ? "    " : "│   "), true);
		if(right != null) right.print2(prefix + (isTail ? "    " : "│   "), true);
		
		//if(left != null && right != null) right.print2(prefix + (isTail ? "    " : "│   "), true);
		//if(right == null && left != null) left.print2(prefix + (isTail ? "    " : "│   "), true);
		
		//}
		/*if (children.size() > 0) {
			children.get(children.size() - 1).print(
					prefix + (isTail ? "    " : "│   "), true);
		}*/
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	public static boolean isBalanced(TreeNode root) {
		return (maxDepth(root) - minDepth(root) <= 1);
	}

}