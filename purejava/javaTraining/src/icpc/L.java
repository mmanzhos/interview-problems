package icpc;

import java.util.Locale;
import java.util.Scanner;

public class L {
	public static void main(String[] argv) {
		Scanner in = new Scanner(System.in);
		in.useLocale(Locale.US);
		int a = in.nextInt();
		int b = in.nextInt();
		int temp = 0;
		String simple = "";
		int count = 0;

		if (a > b) {
			b = swap(a, a = b);
			// temp = b;
			// b = a;
			// a = temp;
		}

		for (int i = a; i <= b; i++) {

			if (i != 1) {
				simple += (isSimple(a, i) && isSimple(a, Palindromize(i))) ? i
						+ " " : ""; //
				count += (isSimple(a, i) && isSimple(a, Palindromize(i))) ? 1
						: 0;
			}
		}
		System.out.println(simple);
		System.out.println(count);
	}

	public static boolean isSimple(int a, int i) {
		int x = 0;
		for (int j = 2; j < i; j++) {
			// System.out.println("i % j ="+i+"%"+j+"="+i%j);
			if (i % j == 0 && j != i)
				x = 1;
		}
		return (x == 0) ? true : false;
	}

	public static int Palindromize(int x) {
		String reversed = "";
		String y = "" + x;
		for (int i = y.length() - 1; i >= 0; i--) {
			reversed += y.charAt(i);
		}
		return Integer.parseInt(reversed);
	}

	static int swap(int a, int b) { // usage: y = swap(x, x=y);
		return a;
	}

}