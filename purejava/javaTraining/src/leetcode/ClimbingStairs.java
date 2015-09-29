package leetcode;



public class ClimbingStairs {

	public int climbStairs(int n) {
        if (n < 1) return 0;
        if (n < 2) return 1;
        if (n < 3) return 2;
        
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        
        for (int i = 2; i < n; i++) {
            result[i] = result[i-2] + result[i-1];
        }
        
        return result[n-1];
    }

}
