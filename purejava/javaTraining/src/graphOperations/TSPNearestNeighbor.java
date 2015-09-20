package graphOperations;


// http://www.sanfoundry.com/java-program-implement-traveling-salesman-problem-using-nearest-neighbour-algorithm/
// https://en.wikipedia.org/wiki/Nearest_neighbour_algorithm


/*
These are the steps of the algorithm:
1. start on an arbitrary vertex as current vertex.
2. find out the shortest edge connecting current vertex and an unvisited vertex V.
3. set current vertex to V.
4. mark V as visited.
5. if all the vertices in domain are visited, then terminate.
6. Go to step 2. 
*/



import java.util.Stack;

public class TSPNearestNeighbor {

	boolean[] visited;
	Stack<Integer> path;
	
	private void process(int node) {
		visited[node] = true;
		System.out.println(node+1);
		path.push(node);
	}
	
	public void tsp(int[][] matrix) {
		int len = matrix.length;
		int destination = 0;
		
		visited = new boolean[len];
		path = new Stack<Integer>();
		
		process(0);
		
		while (!path.isEmpty()) {
			int top = path.peek();
			
			int min = Integer.MAX_VALUE;
			boolean wasMin = false;
			
			
			for (int i = 0; i < len; i++) {
				if (matrix[top][i] > 0 && visited[i] == false) {
					if (matrix[top][i] < min) {
						min = matrix[top][i];
						destination = i;
						wasMin = true;
					}
				}
			}
			
			if (wasMin) {
				process(destination);
			} else {
				path.pop();
			}
			
		}
		
		
	}
	

	public static void main(String[] args) {
		
		GraphWeighted g = new GraphWeighted(10, false);
		
		
		int[][] adjMatrix = {
				{0,   374, 200, 223, 108, 178, 252, 285, 240, 356},
				{374, 0,   255, 166, 433, 199, 135, 95,  136, 17 },
				{200, 255, 0,   128, 277, 128, 180, 160, 131, 247},
				{223, 166, 128, 0,   430, 47,  52,  84,  40,  155},
				{108, 433, 277, 430, 0,   453, 478, 344, 389, 423},
				{178, 199, 128, 47,  453, 0,   91,  110, 64,  181},
				{252, 135, 180, 52,  478, 91,  0,   114, 83,  117},
				{285, 95,  160, 84,  344, 110, 114, 0,   47,  78 },
				{240, 136, 131, 40,  389, 64,  83,  47,  0,   118},
				{356, 17,  247, 155, 423, 181, 117, 78,  118, 0  },
		};
		
		
		
		g.representation = adjMatrix;
		
		
		
		System.out.println("The cities are visited as follows:");
        TSPNearestNeighbor tspNearestNeighbour = new TSPNearestNeighbor();
        tspNearestNeighbour.tsp(g.representation);		
        
        
        
        // expected result: 1 5 3 4 9 8 10 2 7 6 
	}

}
