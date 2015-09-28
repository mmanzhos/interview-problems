package graphOperations;

import java.util.HashSet;
import java.util.PriorityQueue;


/* Thoughts:
 * 1. It may be hard to implement algorithm, because it depends on implementation of graph.
 * 1.1. Adjacency matrix 
 * 1.2. Adjacency list + PQ
 * 1.3. etc.
 * 1.4. And in unprepared case it may take a long time to implement, because of wasting time on fixing unobvious bugs.
 * 1.5. Implementation with arrays key/parent, with just matrix, with 1 PQ and 1 visited set
 * 
 * So only general pseudocode may be useful in this situation.
 * 
 * 
 * */
public class PrimMST {
	
	// https://en.wikipedia.org/wiki/Prim%27s_algorithm
	// https://www.youtube.com/watch?v=z1L3rMzG1_A
	public Iterable<Edge> prim(GraphEdgeWeighted g) {
		
		// setup initials
		HashSet<Edge> set = new HashSet<Edge>(g.getSize());
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[g.getSize()];
		
		// set root element as visited
		visited[0] = true;
		// add all edges of root to PQ
		for (Edge e : g.getAdj(0)) {
			pq.offer(e);
		}
		
		// iterate until we visit each node or there is no more edges (no more edges == no circles, graph is tree initially)
		while (!pq.isEmpty() && set.size() < g.getSize() - 1) {
			Edge e = pq.poll();
			
			visited[e.from()] = true;
			// the problem which costed me 20 minutes of looking for bug (infinite loop)
			// it occurs, because edge is unordered, like vertex 0 has edge (0,2), and vertex 2 has edge(0,2)
			// if vertex 2 contains edge (2,0) then this check is unnecessary
			// so it depends on Edge class implementation
			if (visited[e.from()]) visited[e.to()] = true;
			
			// just add this Edge to result set
			set.add(e);
			
			// add each Edge of current Edge.to() to PQ
			// only if only one of the vertex of edge was visited, or neither of them.
			for (Edge adjEdge : g.getAdj(e.to())) {
				// this condition is a little bit unobvious, but it saves from
				// check if both are unvisited
				// check if any is unvisited
				if (visited[adjEdge.from()] && visited[adjEdge.to()]) {
					continue;
				} else {
					pq.offer(adjEdge);
				}
			}

		}
		
		
		
		return set;
	}
	
	
	public static void main(String[] args) {
		
		PrimMST kmst = new PrimMST();
		GraphEdgeWeighted g = GraphEdgeWeighted.createBasicExampleForDijkstra();
		Iterable<Edge> list = kmst.prim(g);
		
		for (Edge e : list) {
			System.out.println(e.from() + " " + e.to());
		}
		
	}

}
