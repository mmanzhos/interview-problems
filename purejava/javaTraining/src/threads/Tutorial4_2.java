package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class WorkerR {
	
	private Random random = new Random();
	
	// separate lock objects is a good practice (c)
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	// 
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	public void stageOne() {
		
		synchronized (lock1) { // synchronized by lock
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			list1.add(random.nextInt(100));
		}
	}
	
	public void stageTwo() {
		
		synchronized (lock2) { // synchronized by lock
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			list2.add(random.nextInt(100));
		}
	}
	
	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}
	
	
	public void main() {
		System.out.println("Hello");
		
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Time taken: " + (System.currentTimeMillis() - start));
		
		
		System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
	}
}


// multiple Locks usage
public class Tutorial4_2 {

	public static void main(String[] args) {
		WorkerR w = new WorkerR();
		w.main();
	}

}
