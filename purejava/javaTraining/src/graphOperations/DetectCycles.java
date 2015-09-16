package graphOperations;

import java.util.Stack;

public class DetectCycles {

	static Stack<Integer> possibleCircleStack;
	
	private static boolean detectCycleUtil(Graph g, boolean[] visited, boolean[] stack, int[] edgeTo, int v) {
		
		if (visited[v] == false) {
			stack[v] = true;
			visited[v] = true;
			
			
			for (int adj = 0; adj < g.getAdj(v).size(); adj++) {
				int val = g.getAdj(v).get(adj);
				if (visited[val] == false) {
					edgeTo[val] = v;
					if(detectCycleUtil(g, visited, stack, edgeTo, val)) {
						return true;
					}
				} else if (stack[val]) {
					for (int x = v; x != val; x = edgeTo[x]) {
						possibleCircleStack.push(x);
					}
					possibleCircleStack.push(val);
					possibleCircleStack.push(v);
					//System.out.println("pushing!");
					return true;
				}
			}
			
		}
		
		stack[v] = false;
		
		return false;
	}

	private static boolean detectCycle(Graph g) {
		possibleCircleStack = new Stack<Integer>();
		
		boolean[] visited = new boolean[g.getSize()];
		boolean[] stack = new boolean[g.getSize()];
		int[] edgeTo = new int[g.getSize()];
		
		for (int v = 0; v < g.getSize(); v++) {
			if (detectCycleUtil(g, visited, stack, edgeTo, v)) {
				while (!possibleCircleStack.isEmpty()) {
					System.out.println(possibleCircleStack.pop());
				}
				return true;
			}
		}
		
		
		
		
		return false;
	}
	
	
	public static void main(String[] args) {

		Graph g = new Graph(4, true);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 0);
		//g.addEdge(3, 3);
		
		boolean isDetected = detectCycle(g);
		System.out.println(isDetected);
	}


}
