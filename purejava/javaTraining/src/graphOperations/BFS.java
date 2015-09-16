package graphOperations;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void bfs(Graph graph, int source) {
		boolean[] visited = new boolean[graph.getSize()];
		Queue<Integer> q = new LinkedList<Integer>();
		
		visited[source] = true;
		q.offer(source);
		
		while (!q.isEmpty()) {
			int top = q.poll();
			System.out.println(top);
			
			for (int i = 0; i < graph.getAdj(top).size(); i++) {
				int val = graph.getAdj(top).get(i);
				if (!visited[val]) {
					visited[val] = true;
					q.offer(val);
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Graph g = Graph.createBasicExampleForDijkstra(true);
		bfs(g, 0);
		
	}

}
