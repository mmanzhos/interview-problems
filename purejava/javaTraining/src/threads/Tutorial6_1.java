package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ProcessorB implements Runnable {
	private CountDownLatch latch;
	
	public ProcessorB(CountDownLatch latch) {
		// TODO Auto-generated constructor stub
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Started.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latch.countDown();
	}
}

public class Tutorial6_1 {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService exe = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 3; i++) {
			exe.submit(new ProcessorB(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed.");
	}

}
