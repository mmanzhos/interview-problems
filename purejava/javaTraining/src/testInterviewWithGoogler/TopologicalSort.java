package testInterviewWithGoogler;

import graphOperations.GraphTS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TopologicalSort {

	ExecutorService exe;
	
	private void doSmth() {
		//System.out.println("New thread #" + Thread.currentThread().getName());
		
		try {
			Thread.sleep(100);
			//System.out.println("Thread #" + Thread.currentThread().getName() + " notified its end");
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void tps(GraphTS g) throws InterruptedException {

		boolean[] incomingVisited = new boolean[g.getSize()];
		int isThereAnyUnvisited = g.getSize();

		while (isThereAnyUnvisited > 0) {
			
			exe = Executors.newCachedThreadPool();
			
			for (int i = 0; i < g.getSize(); i++) {
				
				// there is no need to visit already launched file
				if (incomingVisited[i] == false) {
					boolean areAllVisited = true;
					for (int adjNum = 0; adjNum < g.getReversedAdj(i).size(); adjNum++) {
						int num = g.getReversedAdj(i).get(adjNum);
						if (!incomingVisited[num]) {
							areAllVisited = false;
							break;
						}
					}
					if (areAllVisited) {
						System.out.println(i);
						exe.execute(new Runnable(){
							public void run() {
								doSmth();
							}
						});
						incomingVisited[i] = true;
						isThereAnyUnvisited--;	
					}
				}
			}
			
			exe.shutdown();
			
			try {
				exe.awaitTermination(1, TimeUnit.DAYS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println();
			
			
		}

	}

	public static void main(String[] args) throws InterruptedException {

		TopologicalSort ts = new TopologicalSort();

		GraphTS g = GraphTS.createBasicExample();
		
		System.out.println("topo");
		ts.tps(g);

	}

}
