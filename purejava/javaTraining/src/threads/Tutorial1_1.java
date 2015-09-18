package threads;

// https://www.youtube.com/watch?v=YdlnEWC-7Wo&index=1&list=PLBB24CFB073F1048E

class Runner extends Thread {
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

public class Tutorial1_1 {

	public static void main(String[] args) {
		Runner runner1 = new Runner();
		runner1.start();
		
		Runner runner2 = new Runner();
		runner2.start();
	}

}
