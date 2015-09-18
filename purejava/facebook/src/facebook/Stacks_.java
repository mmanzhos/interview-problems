package facebook;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stacks_ {

	public static void main(String[] args) {
		int n = 3;
		int k = 2;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < 3; i++)
			towers[i] = new Tower(i);
		for (int i = k - 1; i >= 0; i--)
			towers[0].add(i);
		
		//towers[0].print();
		
		//towers[0].moveDisks(k, towers[2], towers[1]);
		
		
		Stack<Integer> ss = new Stack<Integer>();
		ss.push(1);
		ss.push(2);
		ss.push(3);
		ss.push(4);
		ss.push(5);
		
		//sortStack(ss);
		
		Queue q = new LinkedList<Integer>();
		
		
		
		//MainClass.main();
		
		System.out.println(Fibonacci.f(4));
	}
	
	
	public static Stack<Integer> sortStack(Stack<Integer> s){
		Stack<Integer> r = new Stack<Integer>();
		
		/*
		 * Create a result stack
		 * while source stack is not empty
		 * pop it into variable tmp
		 * and than check if resulting stack peek is larger then tmp
		 *  --- NOTE: it checks r.peek() > tmp because pushing to ascending stack starts from the lowest element
		 * if it is the case we should remove wrongly added vars to R and push them into S
		 * in the best case, if everything is okay we have to just add 
		 * 
		 * */
		
		
		while(!s.isEmpty()){
			int tmp = s.pop();
			System.out.println("Pop tmp = " + tmp);
			while(!r.isEmpty() && r.peek() > tmp){
				int tmp2 = r.pop();
				s.push(tmp2);
				System.out.println("Pop r, push s = " + tmp2);
			}
			System.out.println("Push tmp r = " + tmp + "\n --------------");
			r.push(tmp);
		}
		
		return r;
	}
	

}

class Tower {
	private Stack<Integer> disks;
	private int index;

	public Tower(int i) {
		disks = new Stack<Integer>();
		index = i;
	}

	public int index() {
		return index;
	}

	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk " + d);
		} else {
			disks.push(d);
		}
	}

	public void moveTopTo(Tower t) {
		//System.out.println("Recursion moveTopTo");
		//System.out.println("Recursion n = " + n);
		int top = disks.pop();
		t.add(top);
		System.out.println("Move disk " + (top+1) + " from " + (index()+1) + " to " + (t.index()+1));
	}

	public void print() {
		//System.out.println("Contents of Tower " + index());
		for (int i = disks.size() - 1; i >= 0; i--) {
			System.out.println(" " + disks.get(i));
		}
	}

	/*public void moveDisks2(int n, Tower destination, Tower buffer) {
		if (n > 0) {
			System.out.println("Recursion moveDisks");
			System.out.println("Recursion n = "+n);
			moveDisks(n - 1, buffer, destination);
			System.out.println("Recursion end");
			//moveTopTo(destination, n);
			moveTopTo(destination);
			
			System.out.println("Recursion end (moved)");
			buffer.moveDisks(n - 1, destination, this);
			System.out.println("Recursion end - buffer");
		}
	}*/
	
	public void moveDisks(int n, Tower destination, Tower buffer) {
		if (n > 0) {
			
			moveDisks(n-1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n-1, destination, this);
			
		}
	}
}


/*class MainClass {
	  public static void main() {
	    int nDisks = 2;
	    doTowers(nDisks, 'A', 'B', 'C');
	  }

	  public static void doTowers(int topN, char origin, char temporary, char destination) {
		  if (topN == 1){
			  System.out.println("Disk 1 from " + origin + " to " + destination);
		  } else {
		      doTowers(topN - 1, origin, destination, temporary); // describes a task freeing space to move the lowest disk to destination  
		      System.out.println("Disk " + topN + " from " + origin + " to " + destination); // move the lowest disk to destination
		      doTowers(topN - 1, temporary, origin, destination); // return moved disks back to destination
		  }
	  }
	}*/


class Fibonacci {
	public static int f(int n){
		if(n == 0) return 1;
		int result = n*f(n-1);
		System.out.print(n + " * ");
		//System.out.println(result);
		return result;
	}
}



class MyQueue<T>{
	Stack<T> ascending;
	Stack<T> descending;
	
	public MyQueue(){
		// to ascending stack we push in order 5-4-3-2-1 to achieve 1-2-3-4-5 like plates in stack
		ascending = new Stack(); // standard stack 1-2-3
		descending = new Stack(); // reversed stack 3-2-1
	}
	
	public int size(){
		return ascending.size() + descending.size();
	}
	
	public void push(T value){
		ascending.push(value);
	}
	
	public T peek(){
		if(!descending.empty()) return descending.peek();
		while(!ascending.empty() ) descending.push(ascending.pop());
		return descending.peek();
	}
	
	public T pop(){
		if(!descending.empty()) return descending.pop();
		while(!ascending.empty()) descending.push(ascending.pop());
		return descending.pop();
	}

	
	
}












