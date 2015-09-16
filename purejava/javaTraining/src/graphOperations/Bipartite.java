package graphOperations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {

	public static boolean isBipartite(Graph graph, int source) {
		int[] color = new int[graph.getSize()];
		Arrays.fill(color, -1);
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		color[source] = 0;
		q.offer(source);
		
		while (!q.isEmpty()) {
			int top = q.poll();

			for (int i = 0; i < graph.getAdj(top).size(); i++) {
				int val = graph.getAdj(top).get(i);
				if (color[val] == -1) {
					color[val] = 1 - color[top];
					q.offer(val);
				} else if (color[val] == color[top]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		/* 
		 *            5
		 *            /\↑
		 *          ↓/  \
		 *  1 ----→ 3 -→ 6
		 *  ↑    /↑ |   ↑
		 *  |   2   |  /
		 *  | /↑    ↓ /
		 *  0 ----→ 4
		 *  
		 *            ?
		 *            /\↑
		 *          ↓/  \
		 *  1 ----→ 0 -→ ?
		 *  ↑    /↑ |   ↑
		 *  |   1   |  /
		 *  | /↑    ↓ /
		 *  0 ----→ 1
		 *    
		 */
		
		Graph g = Graph.createBasicExampleForDijkstra(false);
		boolean result = isBipartite(g, 0);
		System.out.println(result);
	}

}
