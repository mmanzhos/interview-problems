package variousAlgorithms;

// https://www.topcoder.com/community/data-science/data-science-tutorials/dynamic-programming-from-novice-to-advanced/

public class DynamicProgramming1 {
	
	public static void main(String[] args) {
		int[] values = {1,3,5};
		DP(11, values);
	}
    
    public static void DP(int sum, int[] values) {
    	
		int[] mins = new int[sum+1];
		for(int i = 0; i < mins.length; i++){
			mins[i] = Integer.MAX_VALUE;
		}
		mins[0] = 0;
		
		for(int i = 1; i <= sum; i++){
			int j=0;
			for(; j < values.length; j++){
				if(values[j] <= i && (mins[i-values[j]]+1 < mins[i]) ){
					mins[i] = mins[i-values[j]]+1;
				}
			}
			System.out.println("i: "+i+", j: "+j+", min:"+mins[i]);
		}
		
		System.out.println(mins[sum]);
		
	}
	
	
}
