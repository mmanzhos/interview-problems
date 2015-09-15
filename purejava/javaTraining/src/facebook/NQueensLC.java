package facebook;

import java.util.ArrayList;
import java.util.List;

public class NQueensLC {

	public static int solveNQueens(int n) {
        int[] q = new int[n];
        //List<List<String>> result = new ArrayList<List<String>>();
        Integer result = new Integer(0);
        enumerate(q, 0, result);
        return result;
    }
    
    private static void enumerate(int[] q, int row, Integer result) {
        int N = q.length;
        if (N == row) {
            //result.add(fillList(q));
        	result++;
            return;
        } else {
            for (int i = 0; i < N; i++) {
                q[row] = i;
                if(isSafe(q, row)) enumerate(q, row + 1, result);
            }
        }
    }
    
    /*private static List<String> fillList(int[] q) {
    	List<String> list = new ArrayList<String>();
    	// q = [1, 3, 0, 2];
    	for (int i = 0; i < q.length; i++) {
    		String s = "";
        	for (int j = 0; j < q.length; j++) {
	            if (j == q[i]) s += "Q";
	            else s += ".";
	        }
        	list.add(s);
        }
        return list;
        
         
             [".Q..",  // Solution 1
			  "...Q",
			  "Q...",
			  "..Q."] 
         
    }*/
    
    private static boolean isSafe(int[] q, int row) {
        for (int i = 0; i < row; i++) {
            if (q[i] == q[row] || // same column
                q[i] - q[row] == row - i || // test: [0, 2, 1] - 135 degrees check
                q[row] - q[i] == row - i) return false; // 45 deg.
        }
        return true;
    }
    
    public static void main(String[] args) {
  	  long start = System.currentTimeMillis();
        //int N = Integer.parseInt(args[0]);
        
  	  int N = 8;
  	  
  	  int result = solveNQueens(N);
  	  System.out.println(result);
  	  
  	  long end = System.currentTimeMillis();
	    System.out.println((end - start) + "ms");
    }

	
}
