package threads;

public class ThreadsTests {

	static int counter = 0;
	
	public synchronized static void increment(int i) {
		counter++;
		System.out.println(counter + "mod by " + i);
	}
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				System.out.println("Thread #1 goes in!");
				for (int i = 0; i < 2000; i++) {
					increment(1);
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				System.out.println("Thread #2 goes in!");
				for (int i = 0; i < 2000; i++) {
					increment(2);
				}
			}
		});
		
		
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("--> " + counter);
		
		
	}

}
