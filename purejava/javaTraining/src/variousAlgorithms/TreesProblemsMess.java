package variousAlgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreesProblemsMess {
	public static void main(String[] args) {
		/*
		 * TreeNode<String> root = new TreeNode<String>("A"); { TreeNode<String>
		 * node0 = root.add("B"); { TreeNode<String> node01 = node0.add("D"); }
		 * TreeNode<String> node1 = root.add("C"); { TreeNode<String> node10 =
		 * node1.add("E"); { TreeNode<String> node100 = node10.add("G"); }
		 * //TreeNode<String> node11 = node1.add("F");
		 * 
		 * } }
		 */

		/*
		 * TreeNode<String> root = new TreeNode<String>("A"); { TreeNode<String>
		 * node0 = new TreeNode<String>("B"); root.left = node0;
		 * TreeNode<String> node1 = new TreeNode<String>("C"); root.right =
		 * node1; { TreeNode<String> node10 = new TreeNode<String>("E");
		 * node1.left = node10; { TreeNode<String> node100 = new
		 * TreeNode<String>("H"); node10.left = node100; { TreeNode<String>
		 * node1000 = new TreeNode<String>("J"); node100.left = node1000; }
		 * TreeNode<String> node101 = new TreeNode<String>("G"); node10.right =
		 * node101; } TreeNode<String> node11 = new TreeNode<String>("F");
		 * node1.right = node11; { TreeNode<String> node110 = new
		 * TreeNode<String>("I"); node11.left = node110;
		 * 
		 * } System.out.println(TreeNode.isBalanced(node10) +"\n");
		 * 
		 * }
		 * 
		 * }
		 */

		// int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		// TreeNode root = TreeNode.createMinimalBST(arr);

		// root.print();

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode root = TreeNode.addToTree(arr, 0, arr.length - 1);
		
		int[] arr1 = { 2, 5, 7 };
		TreeNode root1 = TreeNode.addToTree(arr1, 0, arr1.length - 1);

		System.out.println(root.toString());
		System.out.println(root1.toString());
		
		//System.out.println(TreeNode.containsTree(root, root1));
		
		//System.out.println(root.traverseTreeForSubTree(root, root1));

		ArrayList<LinkedList<TreeNode>> list = root.findLevels();
		/*LinkedList<TreeNode> l_list = list.get(3);
		while (l_list.peek() != null) {
			// l_list.pop();
			TreeNode n = l_list.pop();

			System.out.println(n.data);
			System.out.println("parent = " + n.parent.data);

			System.out.println("Successor of " + n.data + " is "
					+ n.getSuccessor().data);
			break;
		}*/

		// System.out.println(list.get(3).peek().data);
		
		
		TreeNode l1 = list.get(2).pop();
		System.out.println(l1.data);
		list.get(2).pop();
		TreeNode l2 = list.get(3).pop();
		System.out.println(l2.data);
		
		//System.out.println(TreeNode.commonAncestor1(l1, l2).data);
		System.out.println(TreeNode.commonAncestor3(root, l1, l2).data);
		
		System.out.println();
		System.out.println();
		
		ArrayList<Integer> buf = new ArrayList<Integer>();
		TreeNode.findSum(root, 7, 0, buf);
		System.out.println(TreeNode.aai.size());
		
		System.out.println();
		System.out.println();
		
		
		TreeNode.printTreeByLevels(root);
		
		/*for (int i = 0; i < TreeNode.aai.size(); i++) {
			ArrayList<Integer> buff = TreeNode.aai.get(i);
			for (int j = 0; j < buff.size(); j++) {
				System.out.print(buff.get(j)+" ");
			}
			System.out.println();
		}*/
		

	}
}

class TreeNode<T> {

	T data;
	TreeNode<T> parent;
	ArrayList<TreeNode<T>> children;

	TreeNode<T> left;
	TreeNode<T> right;

	public TreeNode() {
		this.children = new ArrayList<TreeNode<T>>();
	}

	public TreeNode(T data) {
		this.data = data;
		this.children = new ArrayList<TreeNode<T>>();
		// this.parent = new TreeNode();
	}

	public TreeNode<T> add(T data) {
		TreeNode<T> node = new TreeNode<T>(data);
		node.parent = this;
		children.add(node);

		if (children.size() == 1)
			this.left = children.get(0);
		if (children.size() == 2)
			this.right = children.get(1);

		return node;
	}

	public void print() {
		print("", true);
	}

	private void print(String prefix, boolean isTail) {
		System.out.println(prefix + (isTail ? "└── " : "├── ") + data);
		for (int i = 0; i < children.size() - 1; i++) {
			if (children.get(i) == null)
				return;
			children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
		}
		if (children.size() > 0) {
			children.get(children.size() - 1).print(
					prefix + (isTail ? "    " : "│   "), true);
		}
	}

	public StringBuilder toString(StringBuilder prefix, boolean isTail,
			StringBuilder sb) {
		if (right != null) {
			right.toString(
					new StringBuilder().append(prefix).append(
							isTail ? "│   " : "    "), false, sb);
		}
		sb.append(prefix).append(isTail ? "└── " : "┌── ")
				.append(data.toString()).append("\n");
		if (left != null) {
			left.toString(
					new StringBuilder().append(prefix).append(
							isTail ? "    " : "│   "), true, sb);
		}
		return sb;
	}

	@Override
	public String toString() {
		return this.toString(new StringBuilder(), true, new StringBuilder())
				.toString();
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int md_l = maxDepth(root.left);
		int md_r = maxDepth(root.right);
		int result = 1 + Math.max(md_l, md_r);
		// int result = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		System.out.println("Node " + root.data + "| left = maxDepth " + md_l
				+ " | right = maxDepth " + md_r);
		return result;
	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	public static boolean isBalanced(TreeNode root) {
		System.out.println(maxDepth(root));
		System.out.println(minDepth(root));
		return (maxDepth(root) - minDepth(root) <= 1);
	}

	/*
	 * public static TreeNode addToTree(int[] arr, int start, int end){ if(start
	 * > end) return null;
	 * 
	 * int mid = ((start + end) % 2 != 0) ? (start + end) / 2 : (start + end +
	 * 1) / 2; TreeNode n = new TreeNode(arr[mid]); n.left = addToTree(arr,
	 * start, mid-1); n.right = addToTree(arr, mid+1, end);
	 * System.out.println("start = "+start+" | end = " + end); return n; }
	 * 
	 * public static TreeNode createMinimalBST(int[] arr){ return addToTree(arr,
	 * 0, arr.length-1); }
	 */

	/*
	 * 1. Find middle element of an array and create a node with that value 2.
	 * Insert the left subarray into tree 3. Insert the right subarray into the
	 * tree 4. Recurse
	 */

	public static TreeNode addToTree(int[] arr, int start, int end) {
		if (start > end)
			return null; // 'cause in future we will operate with recursive
							// model and ...

		int middleIndex = (start + end) / 2;
		TreeNode n = new TreeNode(arr[middleIndex]);

		n.left = addToTree(arr, start, middleIndex - 1);
		n.right = addToTree(arr, middleIndex + 1, end);

		if (n.left != null)
			n.left.parent = n;
		if (n.right != null)
			n.right.parent = n;

		return n;
	}

	/*
	 * ArrayList<LinkedList<TreeNode>> findLevelLinkList() { TreeNode root =
	 * this; int level = 0; ArrayList<LinkedList<TreeNode>> result = new
	 * ArrayList<LinkedList<TreeNode>>(); LinkedList<TreeNode> list = new
	 * LinkedList<TreeNode>(); list.add(root); result.add(level, list); while
	 * (true) { list = new LinkedList<TreeNode>(); for (int i = 0; i <
	 * result.get(level).size(); i++) { TreeNode n = (TreeNode)
	 * result.get(level).get(i); if (n != null) { if (n.left != null)
	 * list.add(n.left); if (n.right != null) list.add(n.right); } } if
	 * (list.size() > 0) { result.add(level + 1, list); } else { break; }
	 * level++; } return result; }
	 */

	/*
	 * We have to go through the whole tree from the root element to the bottom.
	 * Each level is a LinkedList - ok. That would be breath-first traversal of
	 * the tree with modification
	 */
	/*
	 * ArrayList<LinkedList<TreeNode>> findLevels(){ TreeNode root = this;
	 * 
	 * ArrayList<LinkedList<TreeNode>> result = new
	 * ArrayList<LinkedList<TreeNode>>(); LinkedList<TreeNode> list = new
	 * LinkedList<TreeNode>(); list.add(root); result.add(list); int level = 0;
	 * 
	 * while(true){
	 * 
	 * list = new LinkedList<TreeNode>();
	 * 
	 * for(int i = 0; i < result.get(level).size(); i++){ TreeNode n =
	 * result.get(level).get(i);
	 * 
	 * if(n != null){ if(n.left !=null) list.add(n.left); if(n.right != null)
	 * list.add(n.right); } }
	 * 
	 * if(list.size() != 0){ result.add(level+1, list); } else { break; }
	 * 
	 * 
	 * level++;
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * return result; }
	 */

	ArrayList<LinkedList<TreeNode>> findLevels() {
		TreeNode root = this;
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();

		int level = 0;

		list.add(root);
		result.add(list);

		while (true) {

			list = new LinkedList<TreeNode>();

			for (int i = 0; i < result.get(level).size(); i++) {
				TreeNode n = result.get(level).get(i);
				// take care about n == null!

				if (n.left != null)
					list.add(n.left);
				if (n.right != null)
					list.add(n.right);

			}

			if (list.size() == 0) {
				break;
			} else {
				result.add(list);
			}

			level++;

		}

		return result;
	}
	
	
	public static void printTreeByLevels(TreeNode root) {

		if (root == null)
			return;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		// List<List<Integer>> resList = new LinkedList<List<Integer>>();

		q.offer(root);

		while (!q.isEmpty()) {
			// List<Integer> subList = new List<Integer>();
			String resStr = "";
			int levelNum = q.size();

			for (int i = 0; i < levelNum; i++) {

				if (q.peek().left != null)
					q.offer(q.peek().left);
				if (q.peek().right != null)
					q.offer(q.peek().right);

				// subList.add(q.poll().val);
				resStr += "" + q.poll().data + " ";
			}

			System.out.println(resStr);
			// resList.add(subList);
		}

		// return resList;

	}
	
	
	
	
	
	
	

	/**
	 * In-order traversal:<br>
	 * Cases:<br>
	 * 1. If element has right child - go to it and then go to the left-most
	 * child 2. If element hasn't right child - go to the parent node and if the
	 * element was right child of the parent, go to the highest parent until
	 * this element is left child of it's parent 3. If element hasn't right
	 * child - got to the parent node and if element was left child - that's it
	 * 
	 */
	public TreeNode getSuccessor() {
		TreeNode root = this;
		TreeNode successor;

		if (root.right != null) {
			successor = root.right.getLeftMostChild();
		} else {
			if (root == root.parent.left) {
				successor = root.parent;
			} else {
				// System.out.println("Here");
				while (root.parent != null) {
					System.out.println("Data = " + root.parent.data);
					if (root.parent.left == root)
						break;
					root = root.parent;
				}
				successor = root.parent;
			}
		}

		return successor;
	}

	public TreeNode getLeftMostChild() {
		TreeNode root = this;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	
	
	
	

	/*static boolean containsTree(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true; // The empty tree is always a subtree
		else
			return subTree(t1, t2);
	}

	static boolean subTree(TreeNode r1, TreeNode r2) {
		if (r1 == null)
			return false; // big tree empty & subtree still not found.
		if (r1.data == r2.data) {
			//System.out.println("here");
			if (matchTree(r1, r2))
				return true;
		}
		return (subTree(r1.left, r2) || subTree(r1.right, r2));
	}

	static boolean matchTree(TreeNode r1, TreeNode r2) {
		if (r2 == null && r1 == null)
			return true; // nothing left in the subtree
		if (r1 != null || r2 == null)
			return true; // custom condition
		if (r1 == null || r2 == null)
			return false; // big tree empty & subtree still not found
		if (r1.data != r2.data)
			return false; // data doesn’t match
		return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	boolean traverseTreeForSubTree(TreeNode leaf1, TreeNode leaf2){
		if(leaf1 == null || leaf2 == null)
			return false;
		
		System.out.println("Leaf 1 = " + leaf1.data);
		System.out.println("Leaf 2 = " + leaf2.data);
		
		if(leaf1.data == leaf2.data){
			if(isSubtree(leaf1, leaf2))
				return true;
			System.out.println("Here");
		}
		return traverseTreeForSubTree(leaf1.left, leaf2) || traverseTreeForSubTree(leaf1.right, leaf2)  ;
	}
	
	
	/**
	 * This is necessary for checking subtree, but we also need a traverser through parent tree
	 */
	static boolean isSubtree(TreeNode p, TreeNode ch){

		if(p == null && ch == null)
			return true;
		else if(p != null && ch == null)
			return true;
		else if(p == null && ch != null)
			return false;
		else if(p.data != ch.data)
			return false;
		
		return isSubtree(p.left, ch.left) && isSubtree(p.right, ch.right);
	}
	
	
	
	
	
	static TreeNode commonAncestor1(TreeNode l1, TreeNode l2){
		// only if nodes are on the same level;
		while( l1.parent != null && l2.parent != null){
			
			l1 = l1.parent;
			l2 = l2.parent;
			
			if(l1 == l2)
				return l1;
			
			/*while( l2.parent != null ){
				l2 = l2.parent;
				if(l1.data == l2.data)
					return l1;
			}*/
			
		}
		return null;
	}
	
	
	// TODO: checkout how common ancsetors work
	static TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (covers(root.left, p) && covers(root.left, q))
			return commonAncestor2(root.left, p, q);
		if (covers(root.right, p) && covers(root.right, q))
			return commonAncestor2(root.right, p, q);
		return root;
	}

	private static boolean covers(TreeNode root, TreeNode p) { /* is p a child of root? */
		if (root == null)
			return false;
		if (root == p)
			return true;
		return covers(root.left, p) || covers(root.right, p);
	}
	
	
	static int TWO_NODES_FOUND = 2;
	static int ONE_NODE_FOUND = 1;
	static int NO_NODES_FOUND = 0;
	
	
	// Checks how many “special” nodes are located under this root
	static int covers(TreeNode root, TreeNode p, TreeNode q) {
		int ret = NO_NODES_FOUND;
		if (root == null)
			return ret;
		if (root == p || root == q)
			ret += 1;
		ret += covers(root.left, p, q);
		if (ret == TWO_NODES_FOUND) // Found p and q
			return ret;
		return ret + covers(root.right, p, q);
	}

	static TreeNode commonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
		if (q == p && (root.left == q || root.right == q))
			return root;
		int nodesFromLeft = covers(root.left, p, q); // Check left side
		if (nodesFromLeft == TWO_NODES_FOUND) {
			if (root.left == p || root.left == q)
				return root.left;
			else
				return commonAncestor3(root.left, p, q);
		} else if (nodesFromLeft == ONE_NODE_FOUND) {
			if (root == p)
				return p;
			else if (root == q)
				return q;
		}
		int nodesFromRight = covers(root.right, p, q); // Check right side
		if (nodesFromRight == TWO_NODES_FOUND) {
			if (root.right == p || root.right == q)
				return root.right;
			else
				return commonAncestor3(root.right, p, q);
		} else if (nodesFromRight == ONE_NODE_FOUND) {
			if (root == p)
				return p;
			else if (root == q)
				return q;
		}
		if (nodesFromLeft == ONE_NODE_FOUND && nodesFromRight == ONE_NODE_FOUND)
			return root;
		else
			return null;
	}
	
	
	
	
	
	static ArrayList<ArrayList<Integer>> aai = new ArrayList<ArrayList<Integer>>();
	// TODO: checkout how this stuff works
	/*static void findSum(TreeNode head, int sum, ArrayList<Integer> buffer, int level) {
		if (head == null)
			return;
		int tmp = sum;
		buffer.add((int)head.data);
		for (int i = level; i > -1; i--) {
			tmp -= buffer.get(i);
			if (tmp == 0)
				print(buffer, i, level);
		}
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		aai.add(buffer);
		findSum(head.left, sum, c1, level + 1);
		findSum(head.right, sum, c2, level + 1);
	}

	static void print(ArrayList<Integer> buffer, int level, int i2) {
		for (int i = level; i <= i2; i++) {
			System.out.print(buffer.get(i) + " ");
		}
		System.out.println();
	}*/
	
	
	
	static void findSum(TreeNode root, int sum, int level, ArrayList<Integer> buffer){
		if(root == null) return;
		
		buffer.add((int)root.data);
		int tmp = sum;
		
		for(int i = level; i >= 0; i--){
			tmp -= buffer.get(i);
			if(tmp == 0)
				printSums(buffer, i, level);
		}
		
		ArrayList<Integer> c1 = (ArrayList<Integer>) buffer.clone();
		ArrayList<Integer> c2 = (ArrayList<Integer>) buffer.clone();
		
		findSum(root.left, sum, level+1, c1);
		findSum(root.right, sum, level+1, c2);
		
	}
	
	static void printSums(ArrayList<Integer> buffer, int level, int i2 ){
		for(int i = level; i<=i2; i++){
			System.out.print(buffer.get(i) + " ");
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}