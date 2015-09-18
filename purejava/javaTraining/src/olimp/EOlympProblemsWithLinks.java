package olimp;

import java.util.Scanner;




public class EOlympProblemsWithLinks
{
	public static void main(String[] argv){
		

		System.out.println(isPrime(0));
		
		
	
	}
	
	private static boolean isPrime(long n)
	{
		if(n < 1) return false;
	    for (int i = 2 ; i <= Math.sqrt(n) ; i++)
	    {
	        if ( n % i == 0 )
	        {
	            return false;
	        }
	    }

	    return true;
	}
	
	
	
	//static int 

	
	
	
	
	
	/*
	 * 
	
	Scanner in = new Scanner(System.in );
		in.useLocale(Locale.US);
		int a = in.nextInt();
		int b = in.nextInt();
		int temp = 0;
		String simple = "";
		int count = 0;
		
		if(a > b){
			b = swap(a, a=b);
			//temp = b;
			//b = a;
			//a = temp;
		}
		
		for(int i = a; i <= b; i++){
			
			if(i!=1){
				simple += (isSimple(a, i) && isSimple(a, Palindromize(i))) ? i+" " : ""; //  
				count += (isSimple(a, i) && isSimple(a, Palindromize(i))) ? 1 : 0;
			}
		}
		//System.out.println(simple);
		System.out.println(count);
	}
	
	public static boolean isSimple(int a, int i){
		int x = 0;
		for(int j = 2; j < i; j++){
			//System.out.println("i % j ="+i+"%"+j+"="+i%j);
			if(i % j == 0 && j != i) x = 1;
		}
		return (x==0) ? true : false;
	}
	
	public static int Palindromize(int x){
		String reversed = "";
		String y = ""+x;
		for(int i = y.length()-1; i >= 0 ; i--){
			reversed += y.charAt(i);
		}
		return Integer.parseInt(reversed);
	}
	
	static int swap(int a, int b) {  // usage: y = swap(x, x=y);
	   return a;
	}
	
	
	 * 
	 * 
	 * */
	
	
	
	
	
	
	
	
	
	/*
	 
	 	Scanner in = new Scanner(System.in );
//			in.useLocale(Locale.US);
//			
//			int n = in.nextInt();
//			
//			int[] steps = new int[n];
//			for(int i = 0; i<n; i++)
//				steps[i] = in.nextInt();
//			
//			int k = in.nextInt();
//			
//			int sum = 0;
//			
//			
//			/*
//			 * допустим что наши ступеньки это : 1 -1 -1 1
//			 * если k > 1, то не обязательно наступать на кажую ступеньку, лучше их переступать
//			 * значит нужно узнать, на сколько мы можем переступить.
//			 * 
//			 * */
//			for(int i = 0; i < n; i++){
//				// теория с <0 не работает, потому что на ступеньках могут быть написаны цифры -1 -2 -3 и т.д.
//				// задача: набрать максимально возможное количество очков.
//
//				int k_max = -1001; //максимум, который можно переступить, если все варианты меньше 0.
//				int k_last = 0;
//				int i_last = 0;
//				int k_sum = 0;
//				
//				int current_i = i;
//				if( steps[i]<0){
//					//System.out.println( "i="+i);
//					
//					//надо 2 цикла: 1) на проверку поиска максимума в блиайших шагах; 2) на проверку 
//					for(int j = 1; j < k; j++){
//						if(i+j < steps.length){
//							
//							k_sum += steps[i+j];
//							
//							/*if(j == k-1){
//								k_last = steps[i+j];
//								k_sum -= steps[i+j];
//								i_last = i+j;
//							}*/
//							
//							
//							
//							if(steps[i+j] >= k_max){
//								k_max = steps[i+j];
//								current_i = i+j;
//								//System.out.println( steps[i+j] );
//								//System.out.println( "i="+(i) );
//								//System.out.println( "+step="+(i + j) );
//							}
//							
//							//System.out.println( steps[i+j] );
//							
//							
//							
//						}
//					}
////					if(k_sum < k_last){
////						sum += k_last;
////						//current_i = i_last;
////					}
////					else 
//					if(i < n-1) sum += k_max;
//				} else {
//					sum += steps[i];
//				}
//				
//				//System.out.println( k_sum );
//				//System.out.println( k_last );
//				
//				i = current_i;
//				//sum += k_max;
//
//			}
//			
//			
//				System.out.println( sum );
//			
//				

	
	/*
	 * 
	 
	 		Scanner in = new Scanner(System.in );
			in.useLocale(Locale.US);
			
			int m = in.nextInt();
			for(int i = 0; i < m; i++){
				int n = in.nextInt();
				int sum_5 = 0;
				//System.out.println( sum_5 );
				for(int j = 0; j < n; j++){
					String[] z = in.nextLine().replace(":", "").split(" ");
					if(z.length == 1){
						z = in.nextLine().replace(":", "").split(" ");
					}
					sum_5 += 6;
					for(int h = 1; h < z.length; h++){
						int k = Integer.parseInt(z[h]);
						if(k == 0) break;
						if(h != 0) sum_5 -= 1;
					}
				}
				System.out.println( sum_5 );
			}
				
	 
	 * 
	 * */
	
	/*
	 *
	 * 
	        Scanner in = new Scanner(System.in );
			in.useLocale(Locale.US);
			
			int m = in.nextInt();
			int n = in.nextInt();
			int k = in.nextInt();
			
			int c = m / n;
			int oper = c * n;
			
			String answer = c+".";
			
	        for(int i = 0; i < k; i++){
	        	int a1 = 0;
	        	
	        	a1 = m-oper;
	        	//System.out.println( a1 );
	        	c = a1 * 10 / n;
	        	//System.out.println( c );
	        	answer += ""+c;
	        	m = a1*10;
	        	//System.out.println( m );
	        	oper = c * n;
	        	//System.out.println( oper );
	        	
	        	//System.out.println(  );
	        	
	        	
	        	//answer += ""+a1;
	    	    
	        }
	        
	        System.out.println( answer );
	 
	 
	 * */
	
	       
	
	/*
	 * 
	 	   Scanner in = new Scanner(System.in );
	       int x1 = in.nextInt();
	       int changes = 0;
	       
	       while(x1!=1){
	    	   if(x1 % 2 != 0) x1 += 1;
	    	   else x1 /= 2;
	    	   changes++;
	       }
	       
	       
	       System.out.println( changes );
	 * 
	 * */
	
	       
	/*
	 * 
	 
	 		Scanner in = new Scanner(System.in );
	       int x1 = in.nextInt();
	       int y1 = in.nextInt();
	       int x2 = in.nextInt();
	       int y2 = in.nextInt();
	       int z2 = in.nextInt();
	       double D = Math.round(  1000  /  Math.sqrt(  z2*z2  +  (x2-x1)*(x2-x1)  +  (y2-y1)*(y2-y1)   )   );
	       double c1 = z2*z2;
	       double c2 = (x2-x1)*(x2-x1);
	       double c3 = (y2-y1)*(y2-y1);
	       double c4 = Math.sqrt(  z2*z2  +  (x2-x1)*(x2-x1)  +  (y2-y1)*(y2-y1)   );
	       double c5 = 1 / c4;
	       double X = D / 1000.0;
	       
	       
	       //System.out.println( c1 + " " + c2 + " " + c3 + " " + c4 + " " + c5);
	       
	       System.out.format(Locale.US, "%.3f%n", X);
	 
	 * 
	 * */
	
	
	
	       
		/*
		 *
		 
		 		Scanner in = new Scanner(System.in );
		in.useLocale(Locale.US);
		
		long sum_e = in.nextLong();
		long sum_c = 0;
		long prev = 0;
		int years = 0;
		int i = 0;
		
		//ArrayList<Long> xx = new ArrayList<Long>();
		
		
		while(sum_e > sum_c){
			if(i == 0){
				//xx.add(1L);
				sum_c += 1L;
				prev = 1L;
			}
			else {
				sum_c += prev*2L + (i+1);
				prev = prev*2L + (i+1);
				//xx.add(sum_c);
			}
			System.out.println( sum_c );
			i++;
		}
		
		System.out.println( i );
		 
		 * 
		 * */
		
		
		
	/*
	 
	 A : n=(x-y)+1; rounds=0; start=2;  while(n>0) {for(y to n){if(i%start==0) {n--;} }}
	 B : N-1
	 C : for(0 to n) {game=in.read; if(!hash.get(game)) hash<game, min> else ++ }
	 D : 
	 E : 1) check direction; 2) count 
	 F : for-for-for if(AllUnique && !i && !j)
	 G : 
	 H : recursive summarize
	 I
	 J : 
	 K : break if !AllUnique; find max, find min, find middle, max-middle = answer; break again if min!=max!=middle
	 L : 1) 1,2,3,4,...,n; 2) 1*2*3*4*...*n; 3) взять комбинаторную функцию из алгоритма
	 M case, if
	 N наоборот - = штрих, а # = пусто;  Char[][], if(curr == next) +1, till curr!=next
	 

	 * */
		
		
		
/*		BigDecimal h;
		
		Scanner in = new Scanner(System.in );
		in.useLocale(Locale.US);
		
		int m = in.nextInt();
		int n = in.nextInt();
		int k = in.nextInt();
		
		String res = "";
		String x = "" + ((double) 1.0 * m / n);
		
		int v = 0;
		int dot = 0;
		int afterDot = 0;
		String zeros = "";
		
		for(int i = 0; i < x.length(); i++){
			if(x.charAt(i) == '.') dot = i;
		}
		afterDot = x.length() - (dot + 1);
		
		//System.out.println( afterDot );
		
		v = x.length() - 1;
		
		for(int j = 0; j < k - afterDot; j++){
			zeros += x.charAt(v);
		}
		
		if(afterDot > k)
			System.out.println( x.substring(0, dot+k+1) );
		else
			System.out.println( x + zeros );
			*/

		
		
		
		//System.out.format(Locale.US, "%."+k+"f%n", x );

	
	
	
	
	
	/*
	 * 
	 		Scanner in = new Scanner(System.in );
		in.useLocale(Locale.US);
		
		int m = in.nextInt();
		
		ArrayList<String> xx = new ArrayList<String>();
		
		String m_s = "" + m;
		String m_r;
			
		xx.add(m_s);
		
		boolean isPal = false;
		
		int i = 0;
		while(!isPal){
			String curr = xx.get(i);
			if(!isPalindrom(curr)){
				m_r = Palindromize(curr);
				long x1 = Long.parseLong(curr);
				long x2 = Long.parseLong(m_r);
				xx.add(""+(x1 + x2));
			}
			else{
				isPal = true;
			}
			i++;
		}
		
		for(int j = 0; j < xx.size(); j++){
			System.out.println( xx.get(j) );
		}
			
		System.out.println( xx.size() - 1);
		
		public static String Palindromize(String n){
		String reverse = "";
		int length = n.length();
		
		for ( int i = length - 1; i >= 0; i-- )
	         reverse = reverse + n.charAt(i);
	 
	   // if (text.equals(reverse)) isIt = true;
		
		return reverse;
		}
		
		public static boolean isPalindrom(String text){
			
			boolean isIt = false;
			
			String reverse = "";
			int length = text.length();
			
			for ( int i = length - 1; i >= 0; i-- )
		         reverse = reverse + text.charAt(i);
		 
		    if (text.equals(reverse)) isIt = true;
			
			return isIt;
		}
		
	 
	 
	 * 
	 * 
	 * */
	
	
	
	
/* 143
 * 

public static void main(String[] argv) throws IOException{
	new Main().run();
}
		PrintWriter pw;
		Scanner in;
		public void run() throws IOException{
			
		File file = new File("src/olimp/input.txt");
        in = new Scanner(file);
		
        int x = 0;
     
     	int o_x = in.nextInt();
 		int o_y = in.nextInt();
 		int a_x = in.nextInt();
 		int a_y = in.nextInt();
 		int b_x = in.nextInt();
 		int b_y = in.nextInt();
 		int c_x = in.nextInt();
 		int c_y = in.nextInt();
 		
 		int is_1 = (a_x - o_x) * (b_y - a_y) - (b_x - a_x) * (a_y - o_y);
		int is_2 = (b_x - o_x) * (c_y - b_y) - (c_x - b_x) * (b_y - o_y);
		int is_3 = (c_x - o_x) * (a_y - c_y) - (a_x - c_x) * (c_y - o_y);
		
		if((is_1 >= 0 && is_2 >= 0 && is_3 >= 0) ||  (is_1 <= 0 && is_2 <= 0 && is_3 <= 0))
			x = 1;
     
		pw = new PrintWriter(new File("src/olimp/output.txt"));
		pw.println(x);
		pw.close();
	}



 * 
 * */
	
	
	/* 112
	 
	 Scanner in = new Scanner(System.in );
		in.useLocale(Locale.US);
		
		int t1 = in.nextInt();
		int t2 = in.nextInt();
		int t3 = in.nextInt();
		
		double total_time = 0;
		int min = 10001;
		
		//  1.0f/t1*1.0f + 1.0f/t2*1.0f + 1.0f/t3*1.0f
		
		if(t1 < min) min = t1;
		if(t2 < min) min = t2;
		if(t3 < min) min = t3;
		//total_time = min;
		
		
		total_time = 1.0f / (1.0f/t1*1.0f + 1.0f/t2*1.0f + 1.0f/t3*1.0f);
		
		if((t1 != t2 || t2 != t3 || t1 != t3) && total_time > min){
			//total_time = min;
		}
			
		
		System.out.format(Locale.US, "%.2f%n", total_time );
	 
	 * 
	 * */
	
	
	/*
	 * 
	 	Scanner in = new Scanner(System.in );
		in.useLocale(Locale.US);
		
		int K = in.nextInt();
		int N = in.nextInt();
		int M = in.nextInt();
		int D = in.nextInt();
		
		int total = K + N + M;
		//float part_left = 1.0f / (total * 1.0f);
		
		double part_left = 1 - (Math.pow(K, -1) + Math.pow(N, -1) + Math.pow(M, -1));
		double x = Math.round(D * 100 / part_left) / 100.0f;
		
		//System.out.println( x );
		//System.out.println( x%1 );
		
		if(x % 1 != 0)
			System.out.println( -1 );
		else
			System.out.println( Math.round(x) );
	 * 
	 * */
	
	
	/*
	 *  
	 
	 	Scanner in = new Scanner(System.in );
		in.useLocale(Locale.US);
		
		long y;
		
		long A = in.nextLong();
		long B = in.nextLong();
		long C = in.nextLong();
		
		long z = A*B*C;
		long x = z * 6L - 2L*(A*B + B*C + A*C);
		
		System.out.println( z + " " + x );
	 
	 * */
	
	/* 323 100%
	Scanner in = new Scanner(System.in );
	int number = 0;
	int corr = 0;
	
	String initial = "";
	
	initial = in.nextLine();
	initial = initial.toLowerCase();
	initial = initial.replaceAll("[^a-zA-Z0-9 ]", "");
	
	String[] text = initial.split(" ");
	for(int i = 0; i < text.length; i++){
		//System.out.println(text[i]);
		if(text[i].isEmpty()) corr += 1;
	}
	
	System.out.println(text.length - corr);*/
	
	
	/* 330 90%
	 * 
	 * 
	 * 	public static void main(String[] args){
				
		Scanner in = new Scanner(System.in );
		int max = 0;
		int number = 0;
		int correction = 0;
		boolean isPal = false;
		
		String initial = "";
		
		//for(int j = 0; j < 10; j++){
		//	initial += in.nextLine();
		//}
		initial = in.nextLine();
		initial = initial.toLowerCase();
		
		//String initial_trimmed = initial.trim();
		
		initial = initial.replaceAll("[^a-zA-Z0-9 ]", "");
		
		String[] text = initial.split(" ");
		
		for(int i = 0; i < text.length; i++)
		{
			if(text[i].isEmpty()) correction += 1;
			isPal = isPalindrom(text[i]);
			//System.out.println(text[i]);
			if(isPal && text[i].length() > max){
				max = text[i].length();
				number = i+1 - correction;
			}
		}
		
		System.out.println(number);
		System.out.flush();

	}
	
	public static boolean isPalindrom(String text){
		
		boolean isIt = false;
		
		String reverse = "";
		int length = text.length();
		
		for ( int i = length - 1; i >= 0; i-- )
	         reverse = reverse + text.charAt(i);
	 
	    if (text.equals(reverse)) isIt = true;
		
		return isIt;
	}*/
	
	
	
	/* 927
	 * 
	 * 		
	 *  Scanner in = new Scanner(System.in );
		
		int A = in.nextInt();
		int[] Ad = new int[A];
		
		for(int i = 1; i < A; i++){
			Ad[i] = in.nextInt();
		}
		Ad[0] = in.nextInt();
		

		for(int i = 0; i < A; i++){
			if(i == 0) System.out.print(Ad[i]);
			else System.out.print(" " + Ad[i]);
		}
		System.out.println();
		System.out.flush();

	 * 
	 * 
	 * 
	 * */
		
	
	/* http://www.e-olimp.com/problems/916 50%
	 * 
	 * 
	 * 	Scanner in = new Scanner(System.in );
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		int D = in.nextInt();
		
		int operate = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = A; i <= B; i++){
			for(int j = C; j <= D; j++){
				operate = i*j;
				list.add(operate);
			}
		}
		
		HashSet hs = new HashSet();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		
		System.out.println(list.size());
		System.out.flush();
	 * 
	 * */
	
	
	
	/*  http://www.e-olimp.com/problems/908
	 * 		
	 * 	Scanner in = new Scanner(System.in );
		in.useLocale(Locale.US);
		
		int qty = 0;
		int sum = 0;
		
		int A = in.nextInt();
		double[] numbers = new double[A];
		
		for(int j = 0; j < A; j++) {
			numbers[j] = in.nextDouble();
			if(numbers[j] % 6 == 0 && numbers[j]>0 && numbers[j] % 1 == 0) {
				sum += numbers[j];
				qty++;
			}
		}
		
		System.out.println(qty + " " + sum);
		System.out.flush();
	 * 
	 */
	
	
	/*
	 * http://www.e-olimp.com/problems/927
	 * 
	 * 		
	 *  Scanner in = new Scanner(System.in );
		in.useLocale(Locale.US);
		
		int A = in.nextInt();
		
		
		double[] toys = new double[A];
		double[] prices = new double[A];
		
		for(int j = 0; j < A; j++) {
			toys[j] = in.nextDouble();
			prices[j] = in.nextDouble();
		}
		
		int limit = 50;
		int qty = 0;
		
		for(int i = 0; i < A; i++){
			if(prices[i] < limit) qty += toys[i];
 		}
		
		System.out.println(qty);
		System.out.flush();
*/
	
	
	
	/*
	 * http://www.e-olimp.com/problems/109
	 * 
	
	Scanner in = new Scanner(System.in );
	int N = in.nextInt();
	int M = 0;
	
	if(N<10) M = N;
	else if(N>=10 && N < 190 && N%2 == 1) {
		M = 9 + (N-9)/2;
	} else if(N>=190 && N<2890 && N%3 == 0) {
		M = 99 + (N-189)/3;
	} else if(N>=2890 && N%4 == 1) {
		M = 999 + (N-2889)/4;
	}

		//N = (9*1 + 90*2) + (M - 99)*3;
		// M = 99 + (N-189)/3;
	
	
	System.out.println(M);
	System.out.flush();
	
	*/
	
	
	/* 929
	 * 
	 * 
	 * 
	 * // 100%
		Scanner in = new Scanner(System.in );
		in.useLocale(new Locale("US"));
		
		double A = in.nextDouble(); 
		double B = in.nextDouble(); 
		double C = in.nextDouble(); 
		double D = in.nextDouble();
		String x; 
		
		if(A == C && B == D) x="YES";
		else if(A == B && C == D) x="YES";
		else if(A == D && B ==C) x="YES";
		else x="NO";
		System.out.println(x);
		System.out.flush();
		
		*/
	
	
	
	
	
	/* http://www.e-olimp.com/problems/915
	 * 
	 * 
	 * 		
		Scanner in = new Scanner(System.in);
		String[] x = in.nextLine().split(" ");
		
		int a = Integer.parseInt(x[0]);
		int b = Integer.parseInt(x[1]);
		int c = Integer.parseInt(x[2]);
		
		int[] ar = {a, b, c};
		
		Arrays.sort(ar);
		
		if(ar[0]*ar[0] + ar[1]*ar[1] == ar[2]*ar[2]){
			System.out.println( "YES" );
		} else System.out.println( "NO" );
		System.out.flush();
		
		*/
	
	
	
	
	
	
	
	
	/* http://www.e-olimp.com/problems/125
	 * 
	 * public static void main(String[] argv) throws IOException{
		new Main().run();
		}
		PrintWriter pw;
		Scanner sc;
		public void run() throws IOException{
			
		 File file = new File("src/olimp/input.txt");
         sc = new Scanner(file);
		
         String[] x = null;
         String[] y = null;
         while (sc.hasNextLine()) {
        	x = sc.nextLine().split(" ");
     		y = sc.nextLine().split(" ");
     		
         }
         
		
		//System.out.println( sc.nextLine() );
		
		   
		   int hours = Integer.parseInt(y[0]) - Integer.parseInt(x[0]);
		   int minutes = Integer.parseInt(y[1]) - Integer.parseInt(x[1]);
		   int seconds = Integer.parseInt(y[2]) - Integer.parseInt(x[2]);
		   
		   if(seconds < 0){
			   seconds += 60;
			   minutes -= 1;
		   }
		   if(minutes < 0) {
			   hours -= 1;
			   minutes += 60;
		   }
		   if(hours < 0){
			   hours += 24;
		   }

		   
		   System.out.println( hours + " " + minutes + " " + seconds );
		
		
			pw = new PrintWriter(new File("src/olimp/output.txt"));
			pw.println(hours + " " + minutes + " " + seconds);
			pw.close();
		}
	*/

	
	/* http://www.e-olimp.com/problems/903
	 * 
	 * 
	 * Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    //String[] b = a.split(" ");
    
    int c = a / 100;
    int d = a % 100 / 10;
    int e = a - c*100 - d*10;

    if(c > e){
  	System.out.println ( c );
    } else if(c < e){
  	System.out.println ( e ); 
    } else System.out.println ( "=" );
    
    //System.out.println ( result );
    System.out.flush();
    */
	
	
	
	
	/* http://www.e-olimp.com/problems/125
	
	   Scanner in = new Scanner(System.in);
	   String[] x = in.nextLine().split(" ");
	   
	   Scanner in2 = new Scanner(System.in);
	   String[] y = in2.nextLine().split(" ");
	   
	   int hours = Integer.parseInt(y[0]) - Integer.parseInt(x[0]);
	   int minutes = Integer.parseInt(y[1]) - Integer.parseInt(x[1]);
	   int seconds = Integer.parseInt(y[2]) - Integer.parseInt(x[2]);
	   
	   if(seconds < 0){
		   seconds += 60;
		   minutes -= 1;
	   }
	   if(minutes < 0) {
		   hours -= 1;
		   minutes += 60;
	   }
	   if(hours < 0){
		   hours += 24;
	   }

	   
	   System.out.println( hours + " " + minutes + " " + seconds );
   	   System.out.flush();
	   
	   */
	   
	   /* http://www.e-olimp.com/problems/108
	    * 
	   Scanner in = new Scanner(System.in);
	   String[] x = in.nextLine().split(" ");
	   
	   int a = Integer.parseInt(x[0]);
	   int b = Integer.parseInt(x[1]);
	   int c = Integer.parseInt(x[2]);
	   
	   int y = Integer.parseInt(x[0]) + Integer.parseInt(x[1]) + Integer.parseInt(x[2]);
	   int z = Math.round(y/3);
	   
	   if(a > b && a > c && c > b) z = c;
	   else if(a > b && a > c && c < b) z = b;
	   
	   else if(c > b && c > a && a > b) z = a;
	   else if(c > b && c > a && a < b) z = b;
	   
	   else if(b > a && b > c && c > a) z = c;
	   else if(b > a && b > c && c < a) z = a;
	   
	   System.out.println( z );
   	   System.out.flush();
   	   
   	   */
   
	   /* http://www.e-olimp.com/problems/107
	   
	   Scanner in = new Scanner(System.in);
	   int x = in.nextInt();
	   
	   if(x >= 0 && x <=1000) {
	   
		   int a = x / 100;
		   int b = x % 100 / 20;
		   int c = x - a*100 - b*20;
		   
		   if(b >= 4) {
			   b = 0;
			   c = 0;
			   a += 1;
		   }
		   
		   if(c >= 15) {
			   c = 0;
			   b += 1;
		   }
	
		   
		   int sum = a*100 + b*30 + c*2;
		   
		   
		   //System.out.println( a*100 + "+" + b*30 + "+" + c*2 + "=" +  sum );
		   System.out.println( sum );
	   } else {
		   System.out.println( 0 );
	   }
	   System.out.flush();
	  */
	   
	   
	   
	  /* http://www.e-olimp.com/problems/924
	   * 

      Scanner in = new Scanner(System.in);
      String[] a = in.nextLine().split(" ");
      //String[] b = a.split(" ");
      
      double c = Double.parseDouble(a[0]);
      double d = Double.parseDouble(a[1]);
      
      double s2 = d*d*Math.PI;
      double r1 = Math.sqrt((s2-c)/Math.PI);
      
      double result = Math.round(r1 * 100) / 100.0f;
      
      System.out.format( Locale.US, "%.2f%n", result );
      System.out.flush();
      
      */
   }
