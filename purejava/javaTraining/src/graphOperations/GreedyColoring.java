package graphOperations;

import java.util.Arrays;

public class GreedyColoring {

	

	private static int[] coloring(Graph g, int source) {
		int[] result = new int[g.getSize()];
		boolean[] occupiedColors = new boolean[g.getSize()];
		
		Arrays.fill(result, -1);
		
		result[source] = 0;
		//occupied[source] = false;
		
		for (int vertex = 0; vertex < g.getSize(); vertex++) {
			
			for (int adj = 0; adj < g.getAdj(vertex).size(); adj++) {
				int val = g.getAdj(vertex).get(adj);
				if (result[val] != -1) {
					occupiedColors[result[val]] = true;
				}
			}
			
			
			for (int color = 0; color < occupiedColors.length; color++) {
				if (occupiedColors[color] == false) {
					result[vertex] = color;
					break;
				}
			}
			
			
			
			for (int adj = 0; adj < g.getAdj(vertex).size(); adj++) {
				int val = g.getAdj(vertex).get(adj);
				if (result[val] != -1) {
					occupiedColors[result[val]] = false;
				}
			}
			
			
		}
		
		
		
		return result;
	}
	
	
	public static void main(String[] args) {
		
		/*
		 *             5
		 *            /\
		 *           /  \
		 *  1 ----- 3 -- 6
		 *  |     / |   /
		 *  |   2   |  /
		 *  | /     | /
		 *  0 ----- 4
		 */
		
		
		Graph g = Graph.createBasicExampleForDijkstra(false);
		int[] result = coloring(g, 0);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println("Vertex " + i + " color is " + result[i]);
		}
		
	}

	
}
