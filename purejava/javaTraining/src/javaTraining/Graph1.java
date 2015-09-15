package javaTraining;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Vertex {
	boolean isVisited;
	int val;
	public Vertex(int val) {
		this.val = val;
		isVisited = false;
	}
}

class Graph {
	int V;
	LinkedList<Integer>[] adj;
	ArrayList<Vertex>[] adjV;
	Vertex head = null;
	boolean[] isVisited;
	
	public Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	public Graph(int V, boolean vertices) {
		this.V = V;
		adjV = new ArrayList[V];
		for (int i = 0; i < adjV.length; i++) {
			adjV[i] = new ArrayList<Vertex>();
		}
		isVisited = new boolean[V];
	}
	
	public void addEdge(int v, int u) { 
		adj[v-1].add(u);
		adj[u-1].add(v);
	}
	public void addEdgeV(Vertex v, Vertex u) {
		if (head == null) head = v;
		adjV[v.val-1].add(u);
		adjV[u.val-1].add(v);
	}
	
	
	public void printGraph() {
		for (int i = 0; i < adj.length; i++) {
			LinkedList<Integer> list = adj[i];
			System.out.println("Adjacancy list of " + (i+1));
			
			for (int j = 0; j < list.size(); j++) {
				Integer n = list.get(j);
				System.out.println(n);
			}
		}
	}
	public void printGraph(boolean vertices) {
		for (int i = 0; i < adjV.length; i++) {
			ArrayList<Vertex> list = adjV[i];
			System.out.println("Adjacancy list of " + (i+1));
			
			for (int j = 0; j < list.size(); j++) {
				Vertex n = list.get(j);
				System.out.println(n.val);
			}
		}
	}
	
	
	public void bfs() {
		System.out.println("BFS:");
		
		Queue<Vertex> q = new LinkedList<Vertex>();
		isVisited[head.val-1] = true;
		q.offer(head);
		while (q.isEmpty() == false) {
			Vertex v = q.poll();
			System.out.println(v.val);

			ArrayList<Vertex> adjacents = adjV[v.val-1];
			for (int i = 0; i < adjacents.size(); i++) {
				Vertex u = adjacents.get(i);
				if (!isVisited[u.val - 1]) {
					isVisited[u.val - 1] = true;
					q.offer(u);
				}
			}
			
			
		}
	}
	
	public void dfs() {
		System.out.println("DFS:");
		isVisited = new boolean[V];
		
		Stack<Vertex> s = new Stack<Vertex>();
		isVisited[head.val-1] = true;
		s.push(head);
		while (s.isEmpty() == false) {
			Vertex v = s.pop();
			System.out.println(v.val);

			ArrayList<Vertex> adjacents = adjV[v.val-1];
			for (int i = 0; i < adjacents.size(); i++) {
				Vertex u = adjacents.get(i);
				if (!isVisited[u.val - 1]) {
					isVisited[u.val - 1] = true;
					s.push(u);
				}
			}
			
			
		}
	}
	
	
}

public class Graph1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int V = in.nextInt();
		
		Graph G = new Graph(V);
		Graph GV = new Graph(V, true);
		
		
		for (int i = 0; i < V; i++) {
			int v = in.nextInt();
			int u = in.nextInt();
			G.addEdge(v, u);
			
			Vertex vV = new Vertex(v);
			Vertex uV = new Vertex(u);
			GV.addEdgeV(vV, uV);
		}
		
		//G.printGraph();
		GV.printGraph(true);
		GV.bfs();
		GV.dfs();
	}

}
