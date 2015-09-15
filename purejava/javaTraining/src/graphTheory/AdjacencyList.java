package graphTheory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class VertexC {
	boolean visited = false;
	ArrayList<VertexC> neighbors = new ArrayList<VertexC>();
	int name;
	
	public VertexC(int name) {
		this.name = name;
	}
}

class Graph {
    //Map of adjacency lists for each node
    Map<Integer, VertexC> adj;

    public Graph(int[] nodes) {
        //your node labels are consecutive integers starting with one. 
        //to make the indexing easier we will allocate an array of adjacency one element larger than necessary
        adj = new HashMap<Integer, VertexC>();
        for (int i = 1; i <= nodes.length; ++i) {
            adj.put(i, new VertexC(i));
        }
    }
    
    public void printGraph() {
    	for (Map.Entry<Integer, VertexC> vc : adj.entrySet()) {
    		for (VertexC v : vc.getValue().neighbors) {
    			System.out.println("Node " + vc.getValue().name + " has neighbor " + v.name);
    		}
    	}
    	System.out.println("--------");
    }
    
    public void resetVisits() {
    	for (Map.Entry<Integer, VertexC> vc : adj.entrySet()) {
    		for (VertexC v : vc.getValue().neighbors) {
    			vc.getValue().visited = false;
    		}
    	}
    }
    
    public void dfs() {
    	resetVisits();
    	
    	System.out.println("DFS:");
    	Stack<VertexC> s = new Stack<VertexC>();
		VertexC vr = adj.get(1);
		vr.visited = true;
		s.push(vr);
		while (!s.isEmpty()) {
			VertexC v = s.pop();
			System.out.println(v.name);

			for (VertexC vc : v.neighbors) {
				if (!vc.visited) {
					vc.visited = true;
					s.push(vc);
				}
			}
			
		}
		System.out.println("--------");
    }
    
    public void bfs() {
    	resetVisits();
    	
    	System.out.println("BFS:");
    	Queue<VertexC> q = new LinkedList<VertexC>();
		VertexC vr = adj.get(1);
		vr.visited = true;
    	q.offer(vr);
		while (!q.isEmpty()) {
			VertexC v = q.poll();
			System.out.println(v.name);

			for (VertexC vc : v.neighbors) {
				if (!vc.visited) {
					vc.visited = true;
					q.offer(vc);
				}
			}
			
		}
		System.out.println("-------");
    }

}

public class AdjacencyList {

	public static void main(String[] args) {
		try {
			File file = new File("res/graph1.txt");
			//System.out.println(file.getAbsolutePath());
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String line = br.readLine();

	        if (line != null) {
	            //read nodes
	            String[] nodeNames = line.split(" ");
	            int[] nodes = new int[nodeNames.length];
	            for (int i = 0; i < nodes.length; ++i) {
	               nodes[i] = Integer.parseInt(nodeNames[i]);
	            }

	            //create graph
	            Graph g = new Graph(nodes);

	            //read edges
	            while((line = br.readLine()) != null) {
	                String[] tokens = line.split(" ");
	                int v1 = Integer.parseInt(tokens[0]);
	                int v2 = Integer.parseInt(tokens[1]);


	                //we add neighbor to each node in both directions.
	                VertexC vertex1 = g.adj.get(v1);
	                VertexC vertex2 = g.adj.get(v2);
	                vertex1.neighbors.add(vertex2);
	                vertex2.neighbors.add(vertex1);
	            }
	            
	            g.printGraph();
	            g.bfs();
	            g.dfs();

	        }
	        br.close();
	        
	        
	        
	    }
	    catch(Exception e) {
	        System.err.println("Error :(");
	    }
	}
	
}
