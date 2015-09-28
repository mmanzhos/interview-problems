package graphOperations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BellmanFord {

	private boolean[] onQueue;
	
	public void findShortestPath(GraphEdgeWeighted g) {
		int V = g.getSize();
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		onQueue = new boolean[V];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		onQueue[0] = true;
		
		while (!q.isEmpty()) {
			int v = q.poll();
			onQueue[v] = false;
			for (Edge e : g.getAdj(v)) {
				int w = e.to();
				int weight = e.getWeight();
				if (dist[v] + weight < dist[w]) {
					dist[w] = dist[v] + weight;
					if (!onQueue[w]) {
						q.offer(w);
						onQueue[w] = true;
					}
				}
			}
		}
		
		/*for (int i = 0; i < V; i++) {
			for (int v = 0; v < V; v++) {
				for (Edge e : g.getAdj(v)) {
					int w = e.to();
					int weight = e.getWeight();
					if (dist[v] + weight < dist[w]) {
						dist[w] = dist[v] + weight;
					}
				}
			}
		}*/
		
		for (int i = 0; i < dist.length; i++) {
			System.out.println(dist[i]);
		}
		
	}
	
	public static void main(String[] args) {
		GraphEdgeWeighted g = GraphEdgeWeighted.createBasicExampleWeighted();
		BellmanFord bf = new BellmanFord();
		bf.findShortestPath(g);
	}

}
