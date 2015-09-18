package threads;

//https://www.youtube.com/watch?v=YdlnEWC-7Wo&index=1&list=PLBB24CFB073F1048E

class RunnerR implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Tutorial1_2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnerR());
		Thread t2 = new Thread(new RunnerR());
		
		t1.start();
		t2.start();
	}
}
