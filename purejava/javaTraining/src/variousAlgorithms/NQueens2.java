package variousAlgorithms;

public class NQueens2 {
	
	// N=15, 70k solutions with Q on b[0];
	private static int N = 8;
	
	private static int[] b = new int[N];
	  private static int s = 0;
	 
	  static boolean unsafe(int y) {
	    int x = b[y];
	    for (int i = 1; i <= y; i++) {
	      int t = b[y - i];
	      if (t == x ||
	          t == x - i ||
	          t == x + i) {
	        return true;
	      }
	    }
	 
	    return false;
	  }
	 
	  public static void putboard() {
	    System.out.println("\n\nSolution " + (++s));
	    for (int y = 0; y < N; y++) {
	      for (int x = 0; x < N; x++) {
	        System.out.print((b[y] == x) ? "|Q" : "|_");
	      }
	      System.out.println("|");
	    }
	  }
	 
	  public static void main(String[] args) {
		long start = System.currentTimeMillis();
	    int y = 0;
	    b[0] = -1;
	    while (y >= 0) {
	      do {
	        b[y]++;
	      } while ((b[y] < N) && unsafe(y));
	      if (b[y] < N) {
	        if (y < N-1) {
	          b[++y] = -1;
	        } else {
	          putboard();
	        }
	      } else {
	        y--;
	      }
	    }
	    
	    long end = System.currentTimeMillis();
	    System.out.println((end - start) + "ms");
	  }
	
}
