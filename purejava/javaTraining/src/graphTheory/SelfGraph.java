package graphTheory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Vertex {
	int name;
	HashMap<Integer, Vertex> neighbors;
	boolean isVisited = false;
	
	public Vertex(int name) {
		this.name = name;
		neighbors = new HashMap<Integer, Vertex>();
	}
	
	public void addVertex(int name) {
		neighbors.put(name, new Vertex(name));
	}
	
	public void fillNeighbors(int[][] array, Vertex vertex) {
		for (int i = vertex.name; i < array.length; i++) {
			if (array[vertex.name - 1][i] == 1) {
				Vertex tmp = new Vertex(i + 1);
				vertex.neighbors.put(tmp.name, tmp);
				System.out.println("Add neighbor " + tmp.name + " to a Vertex " + vertex.name);
				fillNeighbors(array, tmp);
			}
			/*     1
			 *   / | \
			 *   2 4--5
			 *   \/
			 *    3
			 * 
			 * */
		}
		return;
	}
	
	public void bfs() {
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(this);
		while (!q.isEmpty()) {
			Vertex v = q.poll();
			
			if (!v.isVisited) {
				v.isVisited = true;
				System.out.println(v.name);
				/*for (Vertex vn : v.neighbors) {
					q.offer(vn);
				}*/
				for (Map.Entry<Integer, Vertex> e : v.neighbors.entrySet()) {
					q.offer(e.getValue());
				}
			}
		}
	}
	
}

public class SelfGraph {

	public static void main(String[] args) {

		int[][] array = {
			{0, 1, 0, 1, 1},
			{1, 0, 1, 0, 0},
			{0, 1, 0, 1, 0},
			{1, 0, 1, 0, 1},
			{1, 0, 0, 1, 0}
		};
		
		/*     1
		 *   / | \
		 *   2 4--5
		 *   \/
		 *    3
		 * 
		 * */
		
		Vertex s = new Vertex(1);
		Vertex d = s;
		
		//s.fillNeighbors(array, s);
		
		/*
		 * 1 2
		 * 1 4
		 * 1 5
		 * 2 3
		 * 3 4
		 * 4 5
		 * */
		
		
		d.addVertex(2);
		d.addVertex(4);
		d.addVertex(5);
		
		d = d.neighbors.get(2);
		d.addVertex(3);
		
		d = d.neighbors.get(3);
		d.addVertex(4);
		
		d = d.neighbors.get(4);
		d.addVertex(5);
		
		
		
		
		
		
		
		System.out.println("BFS:");
		s.bfs();
		
		
		
	}

}
