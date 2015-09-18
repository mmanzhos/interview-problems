package threads;

public class Tutorial3_2 {
	
	private int count = 0;
	
	// this may be called as *Lock*
	// as it acts like lock, execution time increases, but it guarantees correct result
	// what without keyword synchronized is not guaranteed.
	public synchronized void increment() {
		count++;
	}
	
	public static void main(String[] args) {
		Tutorial3_2 tut = new Tutorial3_2();
		tut.doWork();
		
	}
	
	public void doWork() {
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				for (int i = 0; i < 10000; i++) {
					increment();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				for (int i = 0; i < 10000; i++) {
					increment();
					
					// count = count + 1;
					// not atomic!
					// get count
					// add 1
					// write to count
				}
				
			}
		});
		
		long time = System.nanoTime();
		//System.out.println(time);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count is: " + count);
	
		System.out.println((System.nanoTime() - time)/1000/1000);
	}
}
