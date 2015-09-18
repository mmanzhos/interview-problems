package threads;

import java.util.Scanner;

class Processor extends Thread {
	
	private volatile boolean running = true;
	
	public void shutdown() {
		running = false;
	}
	
	public void run() {
		
		while (running) {
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}


public class Tutorial2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Processor p1 = new Processor();
		
		p1.start();
		
		System.out.println("Press return to stop:");
		Scanner in = new Scanner(System.in);
		in.nextLine();
		
		p1.shutdown();
		
		
	}

}
