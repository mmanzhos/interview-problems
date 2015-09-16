package graphOperations;

import java.util.Arrays;

public class Dijkstra {

	private static int getIndexOfMinVertex(GraphWeighted g, int source, int[] dist, boolean[] shortestPath) {
		int index = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < g.getSize(); i++) {
			if (shortestPath[i] == false && dist[i] < min) {
				min = dist[i];
				index = i;
			}
		}
		
		return index;
	}
	
	public static int[] dijkstra(GraphWeighted g, int source) {
		int len = g.getSize();
		int[] dist = new int[len];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] shortestPath = new boolean[len];
		
		dist[source] = 0;
		
		for (int vertex = 0; vertex < len; vertex++) {
			
			int inspectedVertex = getIndexOfMinVertex(g, vertex, dist, shortestPath);
			shortestPath[inspectedVertex] = true;
			
			for (int adj = 0; adj < g.getSize(); adj++) {
				if (g.getEdge(inspectedVertex, adj) > 0 && shortestPath[adj] == false &&
					dist[inspectedVertex] + g.getEdge(inspectedVertex, adj) < dist[adj]  ) {
					dist[adj] = dist[inspectedVertex] + g.getEdge(inspectedVertex, adj);
				}
			}
			
		}
		
		return dist;
	}
	
	
	
	public static void main(String[] args) {

		GraphWeighted g = GraphWeighted.createBasicExampleForDijkstra(false);
		int[] result = dijkstra(g, 0);
		
		for (int n : result) {
			System.out.println(n);
		}
		
	}

	

}
