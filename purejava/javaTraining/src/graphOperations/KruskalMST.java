package graphOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalMST {

	class UnionFind {
		int[] root;
		int[] rank;
		
		public UnionFind(int V) {
			root = new int[V];
			rank = new int[V];
			for (int i = 0; i < V; i++) {
				root[i] = i;
			}
		}
		
		public void union(int u, int v) {
			int x = find(u);
			int y = find(v);
			if (x == y) return;
			
			if (rank[x] < rank[y]) {
				root[x] = y;
			} else if (rank[x] > rank[y]) {
				root[y] = x;
			} else {
				root[y] = x;
				rank[x]++;
			}
		}
		
		public int find(int i) {
			while (i != root[i]) {
				i = root[i];
				root[i] = root[root[i]];
			}
			return i;
		}
		
		
		
	}
	
	
	// http://algs4.cs.princeton.edu/43mst/
	// https://www.youtube.com/watch?v=5xosHRdxqHA
	public ArrayList<Edge> kruskal(GraphEdgeWeighted g) {
		int totalWeight = 0;
		ArrayList<Edge> list = new ArrayList<Edge>(g.getSize());
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		for (Edge e : g.getEdges()) {
			pq.offer(e);
		}
		
		UnionFind uf = new UnionFind(g.getSize());
		
		while (!pq.isEmpty() && list.size() < g.getSize() - 1) {
			Edge e = pq.poll(); // get min
			int u = e.from();
			int v = e.to();
			if (uf.find(u) != uf.find(v)) { // if they are in different sets
				uf.union(u, v);
				list.add(e);
				totalWeight += e.getWeight();
			}
		}
		
		System.out.println(totalWeight);
		
		return list;
	}
	
	public static void main(String[] args) {
		
		KruskalMST kmst = new KruskalMST();
		GraphEdgeWeighted g = GraphEdgeWeighted.createBasicExampleForDijkstra();
		List<Edge> list = kmst.kruskal(g);
		
		for (Edge e : list) {
			System.out.println(e.from() + " " + e.to());
		}
		
	}

}
