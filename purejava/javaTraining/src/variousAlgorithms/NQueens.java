package variousAlgorithms;

import java.io.PrintStream;

public class NQueens {
	
	static PrintStream StdOut = System.out;
	static int counter = 0;
	
	/***************************************************************************
    * Return true if queen placement q[n] does not conflict with
    * other queens q[0] through q[n-1]
    ***************************************************************************/
    public static boolean isValid(int[] q, int row) {
    	for (int i = 0; i < row; i++) {
    		if (q[i] == q[row]) return false; // column check
    		if (q[i] - q[row] == row - i) return false; // 135 degrees check
    		if (q[row] - q[i] == row - i) return false; // 45 degrees check
    	}
    	return true;
    }
    
	    
    /***************************************************************************
     * Print out N-by-N placement of queens from permutation q in ASCII.
     ***************************************************************************/
     public static void printQueens(int[] q) {
    	 counter++;
         int N = q.length;
         for (int i = 0; i < N; i++) {
             for (int j = 0; j < N; j++) {
                 if (q[i] == j) StdOut.print("Q ");
                 else           StdOut.print("* ");
             }
             StdOut.println();
         }  
         System.out.println(counter);
         StdOut.println();
     }
     
     
     /***************************************************************************
      *  Try all permutations using backtracking
      ***************************************************************************/
      public static void enumerate(int N) {
          int[] a = new int[N];
          enumerate(a, 0);
      }

      public static void enumerate(int[] q, int n) {
          int N = q.length;
    	  if (N == n) {
        	  printQueens(q);
        	  return;
          } else {
        	  for (int i = 0; i < N; i++) {
        		  q[n] = i;
        		  if (isValid(q, n)) enumerate(q, n + 1);
        	  }
          }
      }  


      public static void main(String[] args) {
    	  long start = System.currentTimeMillis();
          //int N = Integer.parseInt(args[0]);
          
    	  int N = 8;
    	  
    	  enumerate(N);
    	  long end = System.currentTimeMillis();
  	    System.out.println((end - start) + "ms");
      }


	
	
}
