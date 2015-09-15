package olimp;

import java.util.Locale;
import java.util.Scanner;

public class CodeForces {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in );
		in.useLocale(Locale.US);
		
		int n = in.nextInt();
		int k = in.nextInt();
		
		String output = "";
		
		char first = 'a';
		
		for (int i = 0; i < n; i++) {
			//for (int j = 0; j < k; j++) {
			output += (char) (first+(k-1));
			if(k >= n) k--;
			//}
		}
		
		System.out.println(output);

	}

}
