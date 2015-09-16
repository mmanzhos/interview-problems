package graphOperations;

import java.util.ArrayList;

public class Graph {
	int V;
	private ArrayList<Integer>[] adj;
	boolean isDirected;
	
	public Graph(int V, boolean isDirected) {
		this.V = V;
		this.isDirected = isDirected;
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		getAdj(u).add(v);
		if (!isDirected) getAdj(v).add(u); // for undirected graph
	}

	public int getSize() {
		return V;
	}

	public ArrayList<Integer> getAdj(int i) {
		return adj[i];
	}
	
	public static Graph createBasicExample() {
		Graph g = new Graph(13, true);
		
		// http://algs4.cs.princeton.edu/42digraph/
		
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
		
		return g;
	}
	
	public static Graph createBasicExampleForDijkstra(boolean isDirected) {
		Graph g = new Graph(7, isDirected);
		
		/* 
		 *            5
		 *            /\
		 *           /  \
		 *  1 ----- 3 -- 6
		 *  |     / |   /
		 *  |   2   |  /
		 *  | /     | /
		 *  0 ----- 4
		 *  
		 *  
		 *
		 *            5
		 *            /\↑
		 *          ↓/  \
		 *  1 ----→ 3 -→ 6
		 *  ↑    /↑ |   ↑
		 *  |   2   |  /
		 *  | /↑    ↓ /
		 *  0 ----→ 4
		 */
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(4, 6);
		g.addEdge(6, 5);
		
		return g;
	}
	
} 