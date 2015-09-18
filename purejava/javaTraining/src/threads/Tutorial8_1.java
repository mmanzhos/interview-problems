package threads;

import java.util.Scanner;


class ProcessorC {
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running ...");
			wait();
			System.out.println("Resumed.");
		}
	}
	public void consume() throws InterruptedException {
		
		Scanner in = new Scanner(System.in);
		
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("Waiting for return key.");
			in.nextLine();
			System.out.println("Return key pressed.");
			notify();
			Thread.sleep(5000);
		}
	}
}


public class Tutorial8_1 {

	public static void main(String[] args) {

		ProcessorC processor = new ProcessorC();
		
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
