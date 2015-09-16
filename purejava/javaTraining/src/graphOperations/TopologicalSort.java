package graphOperations;

import java.util.Stack;

public class TopologicalSort {

	private static void topologicalSort(Graph graph, int source, 
			boolean[] visited, Stack<Integer> result) {
		
		visited[source] = true;
		for (int i = 0; i < graph.getAdj(source).size(); i++) {
			int val = graph.getAdj(source).get(i);
			if (!visited[val]) {
				topologicalSort(graph, val, visited, result);
			}
		}
		result.push(source);
	}
	
	public static void topologicalSort(Graph graph) {
		boolean[] visited = new boolean[graph.getSize()];
		Stack<Integer> result = new Stack<Integer>();
		
		for (int i = 0; i < graph.getSize(); i++) {
			if (!visited[i]) {
				topologicalSort(graph, i, visited, result);
			}
		}
		
		while (!result.isEmpty()) {
			System.out.println(result.pop());
		}
		
	}
	
	
	public static void main(String[] args) {
		
		/* 
		 *            5
		 *            /\
		 *           /  \
		 *  1 ----- 3 -- 6
		 *  |     / |   /
		 *  |   2   |  /
		 *  | /     | /
		 *  0 ----- 4
		 */
		
		Graph g = Graph.createBasicExampleForDijkstra(true);
		topologicalSort(g);
		
	}


	

}
