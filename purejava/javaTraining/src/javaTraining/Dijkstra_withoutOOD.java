package javaTraining;

import java.util.Arrays;

public class Dijkstra_withoutOOD {

	int V;
	int[][] graph;
	int[] distances;
	boolean[] stpSet;
	
	public Dijkstra_withoutOOD(int V) {
		this.V = V;
		graph = new int[][]{
			{ 0, 4, 3, 0, 7, 0, 0 },
			{ 4, 0, 6, 5, 0, 0, 0 },
			{ 3, 6, 0, 11, 8, 0, 0 },
			{ 0, 5, 11, 0, 2, 2, 10 },
			{ 7, 0, 8, 2, 0, 0, 5 },
			{ 0, 0, 0, 2, 0, 0, 3 },
			{ 0, 0, 0, 10, 5, 3, 0 }
		};
		distances = new int [V];
		stpSet = new boolean [V];
	}
	
	private void findShortestPath(int source) {
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(stpSet, false);
		
		distances[source] = 0;
		
		for (int verticesExeptOne = 0; verticesExeptOne < V - 1; verticesExeptOne++) {
			int currentVertex = getIndexOfMinVertex();
			stpSet[currentVertex] = true;
			for (int neighbor = 0; neighbor < V; neighbor++) {
				if (stpSet[neighbor] == false && graph[currentVertex][neighbor] > 0 &&
						distances[currentVertex] + graph[currentVertex][neighbor] < distances[neighbor]) {
					distances[neighbor] = distances[currentVertex] + graph[currentVertex][neighbor];
				}
			}
		}
		
		for (int i = 0; i < V; i++) {
			System.out.println((char)('A'+i) + "\t" + distances[i]);
		}
		
	}
	
	
	private int getIndexOfMinVertex() {
		int min = Integer.MAX_VALUE;
		int index = 0;
		
		for (int i = 0; i < V; i++) {
			if (stpSet[i] == false && distances[i] < min) {
				min = distances[i];
				index = i;
			}
		}
		
		return index;
	}

	public static void main(String[] args) {
		Dijkstra_withoutOOD dij = new Dijkstra_withoutOOD(7);
		dij.findShortestPath(0);
	}

}
