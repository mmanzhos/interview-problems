package graphOperations;

import java.util.Stack;

public class DFS {

	public static void dfs(Graph graph, int source) {
		boolean[] visited = new boolean[graph.getSize()];
		Stack<Integer> stack = new Stack<Integer>();
		
		visited[source] = true;
		stack.push(source);
		
		while (!stack.isEmpty()) {
			int top = stack.pop();
			System.out.println(top);
			
			for (int i = 0; i < graph.getAdj(top).size(); i++) {
				int val = graph.getAdj(top).get(i);
				if (!visited[val]) {
					visited[val] = true;
					stack.push(val);
				}
			}
		}
	}
	
	
	private static void dfsRecursive(Graph graph, int source, boolean[] visited) {
		System.out.println(source);
		for (int i = 0; i < graph.getAdj(source).size(); i++) {
			int val = graph.getAdj(source).get(i);
			if (!visited[val]) {
				visited[val] = true;
				dfsRecursive(graph, val, visited);
			}
		}
	}
	
	public static void dfsRecursive(Graph graph, int source) {
		boolean[] visited = new boolean[graph.getSize()];
		
		for (int i = 0; i < graph.getSize(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfsRecursive(graph, i, visited);
			}
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
		dfs(g, 0);
		
		System.out.println();
		
		dfsRecursive(g, 0);
		
	}

}
