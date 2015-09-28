package trees;

import java.util.*;

public class LLRB<Key extends Comparable<Key>, Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;

	private class Node {
		public Key key;
		public Value val;
		public Node left, right;
		public boolean color;

		Node(Key key, Value val) {
			this.key = key;
			this.val = val;
			this.color = RED;
		}
	}

	public Value search(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp == 0)
				return x.val;
			else if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
		}
		return null;
	}

	public void insert(Key key, Value value) {
		root = insert(root, key, value);
		root.color = BLACK;
	}

	private Node insert(Node h, Key key, Value value) {
		if (h == null)
			return new Node(key, value);
		if (isRed(h.left) && isRed(h.right))
			colorFlip(h);
		int cmp = key.compareTo(h.key);
		if (cmp == 0)
			h.val = value;
		else if (cmp < 0)
			h.left = insert(h.left, key, value);
		else
			h.right = insert(h.right, key, value);
		if (isRed(h.right) && !isRed(h.left))
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			h = rotateRight(h);
		return h;
	}

	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private void colorFlip(Node h) {
		h.color = !h.color;
		h.left.color = !h.left.color;
		h.right.color = !h.right.color;
	}

	private boolean isRed(Node h) {
		if (h == null) return false;
		if (h.color) return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		LLRB<Integer, String> rbTree = new LLRB<Integer, String>();
		rbTree.insert(1, "Max");
		rbTree.insert(2, "Alena");
		rbTree.insert(3, "Kotik");
		rbTree.insert(4, "Murchik");
		rbTree.insert(5, "SWAG");
		
		System.out.println(rbTree.search(3));
		System.out.println(rbTree.search(1));
		System.out.println(rbTree.search(5));


		TreeMap<Integer, String> ss = new TreeMap();
	}
	
	
	
}