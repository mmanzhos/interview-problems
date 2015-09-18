package threads;

public class Tutorial3_1 {
	
	private int count = 0;
	
	
	
	public static void main(String[] args) {
		Tutorial3_1 tut = new Tutorial3_1();
		tut.doWork();
		
	}
	
	public void doWork() {
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				for (int i = 0; i < 10000; i++) {
					count++;
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				
				for (int i = 0; i < 10000; i++) {
					count++;
					
					// count = count + 1;
					// get count
					// add 1
					// write to count
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
		
		System.out.println("Count is: " + count);
	}
}
