package graphOperations;


public class GraphWeighted {
	int V;
	int[][] representation;
	boolean isDirected;
	
	public GraphWeighted(int V, boolean isDirected) {
		this.V = V;
		this.isDirected = isDirected;
		representation = new int[V][V];
	}
	
	public void addEdge(int u, int v, int weight) {
		representation[u][v] = weight;
		if (!isDirected) representation[v][u] = weight; // for undirected graph
	}

	public int getSize() {
		return V;
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
	
	public static GraphWeighted createBasicExampleForDijkstra(boolean isDirected) {
		GraphWeighted g = new GraphWeighted(7, isDirected);
		
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
		
		g.addEdge(0, 1, 4);
		g.addEdge(0, 2, 3);
		g.addEdge(0, 4, 1);
		g.addEdge(1, 3, 5);
		g.addEdge(2, 3, 11);
		g.addEdge(3, 4, 5);
		g.addEdge(5, 3, 1);
		g.addEdge(3, 6, 10);
		g.addEdge(4, 6, 10);
		g.addEdge(6, 5, 1);
		
		return g;
	}

	public int getEdge(int source, int i) {
		return representation[source][i];
	}
	
} 