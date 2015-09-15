package benchmarks;

import java.util.Random;

public class Test_ArrayList {

	static int[] ar1;
	static int[] ar2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Random rand = new Random();
		
		int SIZE = 100_000_000;
		Runtime r = Runtime.getRuntime();
		long bench1 = r.totalMemory() - r.freeMemory();
		System.out.println("0");
		ar1 = new int[SIZE];
		long bench2 = r.totalMemory() - r.freeMemory();
		System.out.println((bench2-bench1));
		
		SIZE = SIZE + (SIZE >> 1);
		ar2 = new int[SIZE];
		long bench3 = r.totalMemory() - r.freeMemory();
		System.out.println((bench3-bench2));
		
		
		for (int i = (int) (SIZE/1.5) - 1; i >= 0; i--){
			int tmp = ar1[i];
			ar1[i] = ar2[i];
			ar2[i] = tmp;
		}
		
		
		
		
		
		
		
		
	}

}
