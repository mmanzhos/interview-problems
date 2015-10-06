package ctciTest;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueues {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			q.add(i);
		}
		
		for (int i = 0; i < q.size() - 1; i++) {
			q.add(q.poll());
		}
		
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}
		
	}

}
