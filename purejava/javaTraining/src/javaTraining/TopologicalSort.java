package javaTraining;

import java.util.HashSet;
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
			if (!set.contains(i))
				topologicalSortUtil(graph, i);
		}
	}
	
	private void topologicalSortUtil(int[][] graph, int index) {
		set.add(index);
		for (int j = 0; j < graph.length; j++) {
			if (graph[index][j] > 0) {
				if (!set.contains(j))
					topologicalSortUtil(graph, j);
			}
		}
		stack.push(index);
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
		 * 
		 * 
		 */
		
		TopologicalSort ts = new TopologicalSort();
		ts.topologicalSort(graph);
		
		System.out.println(ts.stack.toString());

		while (!ts.stack.isEmpty()) {
			System.out.println(ts.stack.pop());
		}
		
		
	}
}
