package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Worker {
	
	private Random random = new Random();
	
	private List<Integer> list1 = new ArrayList<Integer>();
	private List<Integer> list2 = new ArrayList<Integer>();
	
	public synchronized void stageOne() {
		try {
			System.out.println(getProperTime() + "\tStageOne ---  " + Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list1.add(random.nextInt(100));
	}
	
	public synchronized void stageTwo() {
		try {
			System.out.println(getProperTime() + "\tStageTwo ---  " + Thread.currentThread().getName());
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list2.add(random.nextInt(100));
	}
	
	public void process() {
		for (int i = 0; i < 30; i++) {
			System.out.println(getProperTime() + " Thread " + Thread.currentThread().getName() + " is here.");
			long start = System.currentTimeMillis();
			stageOne();
			stageTwo();
			System.out.println(getProperTime() + " Thread " + Thread.currentThread().getName() + " finished in " + (System.currentTimeMillis() - start));
		}
	}
	
	/*
	 * Result is so weird, because synchronized keyword, locks not the method, but the whole object Worker.
	 * So any other thread can't ask this object variables and methods
	 * 
	 * 
Time	Thread 1	Thread 2
2377	in, I = 0	in, I = 0
		stageOne()	
2387				stageOne()
2397				stageTwo()
2407	stageTwo()	finished
		in, I = 1
2417	finished	stageOne()
		in, I = 1	
2427				stageTwo()
2437	stageOne()	finished
					in
2447				stageOne()
2457				stageTwo()
2467				finished
					in
					stageOne()
2477				stageTwo()
2487	stageTwo()	finished
					in
2497	finished	stageOne()
		in	
2507				stageTwo()
		
	12 seconds - 4 functions	11 seconds here - 10 functions

	 */
	
	
	private String getProperTime(){
		return String.valueOf(Math.floor((System.nanoTime()/1e8)%1e5));
	}
	
	
	public void main() {
		System.out.println("Hello");
		
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		}, "t1");
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		}, "t2");
		
		
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
public class Tutorial4_1 {

	public static void main(String[] args) {
		Worker w = new Worker();
		w.main();
	}

}
