package leetcode;

public class Pow {

	private double pow(double x, int n) {
		if (n == 0) return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return n % 2 == 0 ? pow(x*x, n/2) : x * pow(x*x, n/2);
	}
	
	private double powIterative(double x, int n) {
		if (n == 0) return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		double result = 1.0;
		while (n != 0) {
			if ((n & 1) != 0)
				result *= x;
			x *= x;
			n /= 2;
		}
		return result;
	}
	
	public static void main(String[] args) {

		Pow pow = new Pow();
		
		for (int n = -5; n <= 5; n++) {
			System.out.println("Test: " + n);
			System.out.println("Result: " + pow.powIterative(2, n));
			System.out.println("Result: " + pow.pow(2, n));
			System.out.println();
		}
		
		
	}

}
