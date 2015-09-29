package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTreePostorderTraversal {


	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<Integer>();

		if (root == null)
			return result;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode top = stack.pop();

			result.addFirst(top.val);

			if (top.left != null)
				stack.push(top.left);
			if (top.right != null)
				stack.push(top.right);

		}

		return result;
	}

}
