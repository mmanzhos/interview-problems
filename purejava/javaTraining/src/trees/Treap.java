package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


// http://habrahabr.ru/post/101818/
public class Treap {

	public int value;
	public int priority;
	
	public Treap left;
	public Treap right;
	
	final int UPPER_BOUND = 100;
	final static Random rand = new Random();
	
	private Treap(int value) {
		this.value = value;
		this.priority = rand.nextInt(UPPER_BOUND);
	}
	
	private Treap(int value, int priority, Treap left, Treap right) {
		this(value);
		this.priority = priority;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Merging rule of maxHeap:
	 * keep that property for a new tree
	 * so element with bigger priority (left.priority or right.priority) should be a new root
	 * Example:
	 *     (4, 20)                      (8, 15) 
	 *    /       \         with       /      \
	 *  (3, 19)  (7, 18)             (6, 10)  (9, 13)
	 * 
	 * 
	 *   20 > 15 ?
	 *   merge (7,18) and (8, 15)
	 *     18 > 15 ?
	 *     merge (null) and (8, 15)
	 *       return (8, 15)
	 *     return    (7, 18)
	 *              /     \
 	 *             null   (8, 15)
 	 *             
 	 *   return    (4, 20)
 	 *            /      \
 	 *         (3, 19)   (7, 18)
 	 *                       \
 	 *                        (8, 15)
 	 *                        /     \
 	 *                    (6, 10)   (9, 13)
	 * 
	 *  yeah, it is not perfectly balanced
	 *  maxHeight = O(c * logn), c = 4;
	 *  
	 */
	public static Treap merge(Treap left, Treap right) {
		if (left == null) return right;
		if (right == null) return left;
		
		if (left.priority > right.priority) {
			Treap newRight = merge(left.right, right);
			System.out.println("Merged to: " + left.value + " > " + newRight.value);
			return new Treap(left.value, left.priority, left.left, newRight);
		} else {
			Treap newLeft = merge(left, right.left);
			System.out.println("Merged to: " + right.value + " > " + newLeft.value);
			return new Treap(right.value, right.priority, newLeft, right.right);
		}
	}
	
	/**
	 * It was hard to decide how to return the result as 2 trees
	 * so I made a returning of a Treap root,
	 * which has left subtree and right subtree, which are resulting Treaps after splitting
	 * <br>
	 * <br>
	 * Never use split result directly,
	 * only with result.left or result.right
	 */
	public static Treap split(Treap initial, int value) {
		/*if (initial == null) return initial;
		
		if (value < initial.value) {
			System.out.println("Left split");
			Treap possibleRoot = split(initial.left, value);
			if (possibleRoot == null) return initial;
			initial.left = possibleRoot.right;
			possibleRoot.right = initial;
			return possibleRoot;
		} else if (value > initial.value) {
			System.out.println("Right split");
			Treap possibleRoot = split(initial.right, value);
			if (possibleRoot == null) return initial;
			initial.right = possibleRoot.left;
			possibleRoot.left = initial;
			return possibleRoot;
		}*/
		
		Treap newTree = null;
		Treap possibleLeft = null;
		Treap possibleRight = null;

		if (initial.value <= value) {
			if (initial.right == null)
				possibleRight = null;
			else {
				Treap splitted = split(initial.right, value);
				newTree = splitted.left;
				possibleRight = splitted.right;
			}
			possibleLeft = new Treap(initial.value, initial.priority,
					initial.left, newTree);
		} else {
			if (initial.left == null)
				possibleLeft = null;
			else {
				Treap splitted = split(initial.left, value);
				possibleLeft = splitted.left;
				newTree = splitted.right;
			}
			possibleRight = new Treap(initial.value, initial.priority, newTree,
					initial.right);
		}
		
		initial.left = possibleLeft;
		initial.right = possibleRight;

		return initial;
	}
	
	// returns new root
	public Treap add(Treap treapToAdd) {
		System.out.println("----------");
		System.out.println("Add " + treapToAdd.value);
		
		Treap splitted = split(this, treapToAdd.value);
		System.out.println("Split result " + splitted.left + " " + splitted.right);
		System.out.println("----- new list -----");
		//this.bfs();
		//System.out.println();
		
		
		/*if (splitted.left == null) {
			if (this.value < treapToAdd.value)
				return merge(this, treapToAdd);
			else
				return merge(treapToAdd, this);
		}
		
		if (splitted.right == null) {
			if (this.value < treapToAdd.value)
				return merge(this, treapToAdd);
			else
				return merge(treapToAdd, this);
		}*/
		
		return merge(merge(splitted.left, treapToAdd), splitted.right);
	}
	
	public Treap remove(int treapWithValue) {
		Treap splitted = split(this, treapWithValue - 1);
		Treap left = splitted.left;
		Treap right = splitted.right;
		right = split(right, treapWithValue);
	    return merge(left, right);
	}
	
	public void bfs() {
		//HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Treap> q = new LinkedList<Treap>();
		q.offer(this);
		while (!q.isEmpty()) {
			int qSize = q.size();
			//if ((qSize & (qSize-1)) == 0) System.out.println();
			
			Treap top = q.poll();
			
			System.out.println("(" + top.value + ", " + top.priority + ") ");
			
			if (top.left != null)
				q.offer(top.left);
			if (top.right != null)
				q.offer(top.right);
		}
	}
	
	public static void main(String[] args) {
		int[] values = {50, 25, 75, 5, 10, 16, 66, 79, 54, 20, 38};
		Treap root = new Treap(50);

		for (int value : values) {
			root = root.add(new Treap(value));
		}
		
		root.bfs();
	}

}
