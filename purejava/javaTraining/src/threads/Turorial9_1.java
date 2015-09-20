package threads;

import java.util.LinkedList;
import java.util.Random;



class ProcessorD {
	
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			
			synchronized (lock) {
				
				while (list.size() == LIMIT) {
					lock.wait();
				}
				
				list.add(value++);
				lock.notify();
			}
			
		}
	}
	public void consume() throws InterruptedException {
		while (true) {
			
			Random random = new Random();
			
			synchronized (lock) {
				
				while (list.size() == 0) {
					lock.wait();
				}
				System.out.print("List size is " + list.size());
				int value = list.removeLast();
				System.out.println("; value is: " + value);
				
				lock.notify();
			}		
			
			Thread.sleep(100);
			
		}
	}
}


public class Turorial9_1 {

	public static void main(String[] args) {

		ProcessorD processor = new ProcessorD();
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		
	}
		
}
