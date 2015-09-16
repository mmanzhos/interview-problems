package javaTraining;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class GraphAdj {
	int V;
	ArrayList<Integer>[] adj;
	
	Queue<Integer> preorder;
	Queue<Integer> postorder;
	Stack<Integer> reversePostorder;
	
	public GraphAdj(int V) {
		this.V = V;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	public void addEdge(int u, int v) {
		adj[u].add(0, v);
		//adj[v].add(u); // for undirected graph
	}
	
	
	private void dfs_rec(int node, HashSet<Integer> visited) {
		visited.add(node);
		System.out.println(node);
		
		preorder.offer(node);
		
		for (int i = 0; i < adj[node].size(); i++) {
			if (!visited.contains(adj[node].get(i))) {
				dfs_rec(adj[node].get(i), visited);
			}
		}
		
		postorder.offer(node);
		reversePostorder.push(node);
	}
	
	public void dfs_rec() {
		preorder = new LinkedList<Integer>();
		postorder = new LinkedList<Integer>();
		reversePostorder = new Stack<Integer>();
		
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i = 0; i < V; i++) {
			if (!visited.contains(i)) {
				dfs_rec(i, visited);
			}
		}
	}
	
	private void dfs_rec_array(int node, boolean[] visited) {
		visited[node] = true;
		System.out.println(node);
		
		for (int i = 0; i < adj[node].size(); i++) {
			if (!visited[adj[node].get(i)]) {
				dfs_rec_array(adj[node].get(i), visited);
			}
		}
	}
	
	public void dfs_rec_array() {
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs_rec_array(i, visited);
			}
		}
	}
	
	
	public void dfs_iter() {
		HashSet<Integer> visited = new HashSet<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		
		visited.add(0);
		s.push(0);
		
		while (!s.isEmpty()) {
			int top = s.pop();
			
			System.out.println(top);
			
			for (int i = 0; i < adj[top].size(); i++) {
				int val = adj[top].get(i);
				
				//System.out.println(val + " child of " + top);
				
				
				if (!visited.contains(val)) {
					visited.add(val);
					s.push(val);
				}
			}
			
		}
		
		
	}
	
	
} 

public class DFS_iter_rec {

	
	
	
	public static void main(String[] args) {

		/*GraphAdj g = new GraphAdj(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(4, 6);
		g.addEdge(6, 5);*/
		
		GraphAdj g = new GraphAdj(13);
		/*g.addEdge(0, 1);
		g.addEdge(0, 5);
		g.addEdge(0, 6);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 5);
		g.addEdge(5, 4);
		g.addEdge(6, 9);
		g.addEdge(6, 4);
		g.addEdge(9, 10);
		g.addEdge(9, 11);
		g.addEdge(9, 12);
		g.addEdge(8, 7);
		g.addEdge(7, 6);
		g.addEdge(11, 12);*/
		g.addEdge(2, 3);
		g.addEdge(0, 6);
		g.addEdge(0, 1);
		g.addEdge(2, 0);
		g.addEdge(11, 12);
		g.addEdge(9, 12);
		g.addEdge(9, 10);
		g.addEdge(9, 11);
		g.addEdge(3, 5);
		g.addEdge(8, 7);
		g.addEdge(5, 4);
		g.addEdge(0, 5);
		g.addEdge(6, 4);
		g.addEdge(6, 9);
		g.addEdge(7, 6);
		
		/* http://algs4.cs.princeton.edu/42digraph/
		 * Preorder:  0 5 4 1 6 9 11 12 10 2 3 7 8 
		 * Postorder: 4 5 1 12 11 10 9 6 0 3 2 7 8 
		 * Reverse postorder: 8 7 2 3 0 6 9 10 11 12 1 5 4 
		 * 
		 * 
		 * 
		 *            5
		 *            /\
		 *           /  \
		 *  1 ----- 3 -- 6
		 *  |     / |   /
		 *  |   2   |  /
		 *  | /     | /
		 *  0 ----- 4
		 */
	
		g.dfs_rec();
		
		while (!g.preorder.isEmpty()) {
			System.out.print(g.preorder.poll() + " ");
		}
		System.out.println();
		
		while (!g.postorder.isEmpty()) {
			System.out.print(g.postorder.poll() + " ");
		}
		System.out.println();
		
		while (!g.reversePostorder.isEmpty()) {
			System.out.print(g.reversePostorder.pop() + " ");
		}
		System.out.println();
		
		
		System.out.println();
		
		g.dfs_rec_array();
		
		System.out.println();
		
		g.dfs_iter();
	}

}
