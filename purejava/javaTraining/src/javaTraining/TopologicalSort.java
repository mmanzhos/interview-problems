package javaTraining;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * Pseudo code: 
 * 
 * for 1 to |V|
 *   if V is NOT visited
 *   	visitChildren(V)
 * 
 * 
 * function visitChildren(Vertex V)
 *   V set as visited
 *   for 1 to V.children
 *   	if C is NOT visited
 *   		visitChildren(C)
 *   push V to the stack
 *   // pushing to the stack here guarantees that
 *   // all children elements were processed and we
 *   // can safely add current element to resulting
 *   // stack and no topologically smaller element 
 *   // will appear earlier than this element
 * 
 * output stack
 * 
 */


public class TopologicalSort {

	HashSet<Integer> set;
	Stack<Integer> stack;
	
	public void topologicalSort(int[][] graph) {
		set = new HashSet<Integer>();
		stack = new Stack<Integer>();
		
		for (int i = 0; i < graph.length; i++) {
			if (!set.contains(i)) {
				topologicalSortUtil(graph, i);
			}
		}
	}
	
	private void topologicalSortUtil(int[][] graph, int index) {
		set.add(index);
		for (int j = 0; j < graph.length; j++) {
			if (graph[index][j] > 0) {
				if (!set.contains(j)) {
					topologicalSortUtil(graph, j);
				}
			}
		}
		stack.push(index);
	}
	
	
	
	/**
	 * I don't know how to make topological sort work iteratively
	 * <br><br>
	 * <b>Playing with JavaDoc :)</b>
	 * @author maks
	 * @param graph represents graph
	 * @param index represents index
	 */
	public void topologicalSortIter(int[][] graph, int index) {
		Stack<Integer> s = new Stack<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		Queue<Integer> resulting = new LinkedList<Integer>();
		
		for (int n = 0; n < graph.length; n++) {
			
			if (!set.contains(n))
				s.push(n);
			
			set.add(n);
			
			
			while (!s.isEmpty()) {
				int top = s.pop();
				
				//System.out.println(top);
				
				for (int i = 0; i < graph.length; i++) {
					if (graph[top][i] > 0) {
						if (!set.contains(i)) {
							set.add(i);
							s.push(i);
						}
					}
				}
				
				resulting.offer(top);
				
			}
			
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		int[][] graph = {
				{0, 0, 0, 1, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0},
				{0, 0, 1, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 1},
				{0, 0, 1, 0, 0, 0, 0}
		};
		
		/**
		 * 0     1     5
		 * ↓     ↓     ↓
		 * 3 → → 2 ← ← 6
		 *       ↓
		 *       4
		 */
		
		TopologicalSort ts = new TopologicalSort();
		ts.topologicalSort(graph);
		
		System.out.println(ts.stack.toString());

		while (!ts.stack.isEmpty()) {
			System.out.println(ts.stack.pop());
		}
		
		//System.out.println();
		//ts.topologicalSortIter(graph, 0);
		
		
	}
}
