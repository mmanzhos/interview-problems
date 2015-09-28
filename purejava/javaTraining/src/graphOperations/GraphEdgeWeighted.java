package graphOperations;

import java.util.HashSet;

class Edge implements Comparable<Edge> {
	private int from;
	private int to;
	private int weight;
	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int from() {
		return this.from;
	}
	
	public int to() {
		return this.to;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
}

public class GraphEdgeWeighted {
	int V;
	HashSet<Edge>[] adj;
	boolean isDirected;
	
	public GraphEdgeWeighted(int V) {
		this.V = V;
		adj = new HashSet[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new HashSet<Edge>();
		}
	}
	public GraphEdgeWeighted(int V, boolean isDirected) {
		this(V);
		this.isDirected = isDirected;
	}
	
	public void addEdge(int u, int v, int weight) {
		adj[u].add(new Edge(u, v, weight));
		if (!isDirected) adj[v].add(new Edge(u, v, weight));
	}
	
	public HashSet<Edge> getAdj(int i) {
		return adj[i];
	}

	public int getSize() {
		return V;
	}
	
	public HashSet<Edge> getEdges() {
		HashSet<Edge> set = new HashSet<Edge>();
		for (HashSet<Edge> adjEl : adj) {
			for (Edge e : adjEl) {
				set.add(e);
			}
		}
		return set;
	}

	
	/*public static GraphWeighted createBasicExample() {
		GraphWeighted g = new GraphWeighted(13, true);
		
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
	}*/
	
	public static GraphEdgeWeighted createBasicExampleForDijkstra() {
		GraphEdgeWeighted g = new GraphEdgeWeighted(7);
		
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
		 */
		
		g.addEdge(0, 1, 4);
		g.addEdge(0, 2, 3);
		g.addEdge(0, 4, 7);
		g.addEdge(1, 3, 5);
		g.addEdge(2, 3, 11);
		g.addEdge(3, 4, 2);
		g.addEdge(5, 3, 2);
		g.addEdge(3, 6, 10);
		g.addEdge(4, 6, 5);
		g.addEdge(6, 5, 3);
		
		return g;
	}
	
	public static GraphEdgeWeighted createBasicExampleWeighted() {
		GraphEdgeWeighted g = new GraphEdgeWeighted(7, true);		
		g.addEdge(0, 1, 4);
		g.addEdge(0, 2, 3);
		g.addEdge(0, 4, 7);
		g.addEdge(1, 3, 5);
		g.addEdge(2, 3, 11);
		g.addEdge(3, 4, 2);
		g.addEdge(5, 3, 2);
		g.addEdge(3, 6, 10);
		g.addEdge(4, 6, 5);
		g.addEdge(6, 5, 3);
		
		return g;
	}

	
} 