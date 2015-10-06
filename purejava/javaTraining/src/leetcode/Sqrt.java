package leetcode;

public class Sqrt {
	
	private int sqrtBinary(int x) {
		if (x < 0)
			throw new NullPointerException("Impossible to process negative value");
		if (x < 2) return x;
		
		int low = 1;
		int high = x;
		
		while (low < high) {
			int mid = (high - low) / 2 + low;
			if (mid <= x / mid) low = mid+1;
			else high = mid;
		}
		
		return high - 1;
	}
	
	private int sqrtNewton(int x) {
		double i = 1.0;
		double j;
		while (true) {
			j = (i + x/i) / 2.0;
			if (Math.abs(i - j) < 0.0000001) {
				break;
			}
			i = j;
		}
		return (int) j;
	}
	
	
	
	public static void main(String[] args) {
		
		Sqrt p = new Sqrt();
		
		for (int n = -1; n < 20; n++) {
			System.out.println("Test: " + n);
			System.out.println("Binary: " + p.sqrtBinary(n));
			System.out.println("Newton: " + p.sqrtNewton(n));
			System.out.println();
		}
		
	}

}
