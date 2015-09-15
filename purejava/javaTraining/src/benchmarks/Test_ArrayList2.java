package benchmarks;

import java.util.ArrayList;
import java.util.List;

public class Test_ArrayList2 {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();
		long bench1 = r.totalMemory() - r.freeMemory();
		System.out.println("0");
		
		
		int size = 100_000_000;
		List<Integer> list = new ArrayList<Integer>(size);
		
		long bench2 = r.totalMemory() - r.freeMemory();
		System.out.println(bench2 - bench1);
		
		for (int i = 0; i < size; i++) {
			list.add(null);
		}
		
		long bench4 = r.totalMemory() - r.freeMemory();
		System.out.println(bench4 - bench2);
		
		
		list.add(null);
		
		long bench3 = r.totalMemory() - r.freeMemory();
		System.out.println(bench3 - bench4);
		
		
		System.out.println("done!");
		
	}

}
