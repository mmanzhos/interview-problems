package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ProcessorA implements Runnable {

	private int id;
	public ProcessorA(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Starting: " + id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed: " + id);
	}
	
}

public class Tutorial5_1 {

	public static void main(String[] args) {
		
		ExecutorService exe = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 5; i++) {
			exe.submit(new ProcessorA(i));
		}
		
		exe.shutdown();
		
		System.out.println("All tasks submitted.");
		
		try {
			exe.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed");
	}

}








