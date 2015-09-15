package javaTraining;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra_withoutOOD_pq {

	class Pair {
		int index;
		int distance;
		public Pair(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
	}
	
	int V;
	int[][] graph;
	int[] distances;
	boolean[] stpSet;
	
	public Dijkstra_withoutOOD_pq() {
		this.V = 7;
		graph = new int[][]{
			{0, 4, 3, 0, 1, 0, 0}, // A
			{0, 0, 0, 5, 0, 0, 0}, // B
			{0, 0, 0, 0, 4, 0, 0}, // C
			{0, 0, 11, 0, 5, 0, 0},// D
			{0, 0, 0, 0, 0, 0, 1}, // E
			{0, 0, 0, 1, 0, 0, 0}, // F
			{0, 0, 0, 0, 0, 1, 0}  // G
		};
		distances = new int [V];
		stpSet = new boolean [V];
	}
	
	class PairCompator implements Comparator<Pair>  {
        @Override
        public int compare(Pair n1, Pair n2) {
            if (n1.distance > n2.distance) {
                return 1;
            } else {
                return -1;
            }
        }
    };
	
	
	private void findShortestPath(int source) {
		if (source >= V) {
			throw new NullPointerException("Source is out of bounds");
		}
		
		Arrays.fill(distances, Integer.MAX_VALUE);
		Arrays.fill(stpSet, false);
		
		
		
		/*distances[source] = 0;
		for (int verticesExeptOne = 0; verticesExeptOne < V - 1; verticesExeptOne++) {
			int currentVertex = getIndexOfMinVertex();
			stpSet[currentVertex] = true;
			for (int neighbor = 0; neighbor < V; neighbor++) {
				if (stpSet[neighbor] == false && graph[currentVertex][neighbor] > 0 && distances[currentVertex] != Integer.MAX_VALUE &&
						distances[currentVertex] + graph[currentVertex][neighbor] < distances[neighbor]) {
					distances[neighbor] = distances[currentVertex] + graph[currentVertex][neighbor];
				}
			}
		}*/

		
		
		
		
		Queue<Pair> PQ = new PriorityQueue<Pair>(V, new PairCompator());
		PQ.offer(new Pair(source, 0));
		distances[source] = 0;
		
		while (!PQ.isEmpty()) {
			Pair p = PQ.poll();
			int currentDistance = p.distance;
			int currentVertex = p.index;
			stpSet[currentVertex] = true;
			
			
			for (int possibleNeighbor = 0; possibleNeighbor < V; possibleNeighbor++) {
				if (stpSet[possibleNeighbor] == false && graph[currentVertex][possibleNeighbor] > 0 &&
						currentDistance + graph[currentVertex][possibleNeighbor] < distances[possibleNeighbor]) {
					distances[possibleNeighbor] = currentDistance + graph[currentVertex][possibleNeighbor];
					PQ.offer(new Pair(possibleNeighbor, distances[possibleNeighbor]));
				}
			}
			
		}
		
		
		
		
		for (int i = 0; i < V; i++) {
			if (distances[i] == Integer.MAX_VALUE)
				distances[i] = -1;
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
		
		
		Dijkstra_withoutOOD_pq dij = new Dijkstra_withoutOOD_pq();
		
		
		long start = System.currentTimeMillis();
		dij.findShortestPath(0);
		
		System.out.println(System.currentTimeMillis() - start);
	}

}
