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


	private int numberOfNodes;
    private Stack<Integer> stack;
 
	public TSPNearestNeighbor() {
		stack = new Stack<Integer>();
	}
 
	public void tsp(int adjacencyMatrix[][]) {
		numberOfNodes = adjacencyMatrix[0].length;
		int[] visited = new int[numberOfNodes];
		
		visited[0] = 1;
		stack.push(0);
		
		int element;
		int dst = 0;
		int i;
		int min = Integer.MAX_VALUE;
		boolean minFlag = false;
		
		System.out.print(0 + 1 + " ");

		// DFS basis
		while (!stack.isEmpty()) {
			element = stack.peek();
			min = Integer.MAX_VALUE;

			// find minimum among adjacent vertices
			for (i = 0; i < numberOfNodes; i++) {
				if (adjacencyMatrix[element][i] > 1 && visited[i] == 0) {
					if (min > adjacencyMatrix[element][i]) {
						min = adjacencyMatrix[element][i];
						dst = i;
						minFlag = true;
					}
				}
			}

			// if minimum was found
			// go to minimum node
			if (minFlag) {
				visited[dst] = 1;
				stack.push(dst);
				System.out.print((dst + 1) + " ");
				minFlag = false;
			} else {
				stack.pop();
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
		for (int i = 0; i < g.getSize(); i++)
        {
            for (int j = 0; j < g.getSize(); j++)
            {
                if (adjMatrix[i][j] == 1 && adjMatrix[j][i] == 0)
                {
                	adjMatrix[j][i] = 1;
                }
            }
        }
		
		
		
		g.representation = adjMatrix;
		
		
		
		System.out.println("The cities are visited as follows:");
        TSPNearestNeighbor tspNearestNeighbour = new TSPNearestNeighbor();
        tspNearestNeighbour.tsp(g.representation);		
        
        
        
        // expected result: 1 5 3 4 9 8 10 2 7 6 
	}

}
