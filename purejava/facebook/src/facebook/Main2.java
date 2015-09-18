package facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main2{
	
	static int c = 0;
	
	public static void main(String[] args){
		permutate("ABCDEF");
		System.out.println("Permutate = "+c);
		
		System.out.println();
		int[] res = {1,2,3};
		permutate2(res);
		System.out.println("Permutate2 = "+c);
		
		System.out.println();
		permute(res);
		System.out.println("Permute = "+c);
	}

	public static void permutate(String val){
		permutate("",val);
	}

	
	private static void permutate(String prefix, String val){
		int len = val.length();
		if(len == 0){
			//System.out.println(prefix);
			c++;
		} else {
			for(int i = 0; i < len; i++){
				permutate( prefix + val.charAt(i), val.substring(0, i) + val.substring(i+1) );
			}
		}
	}
	
	
	
	public static List<List<Integer>> permute(int[] num) {
		c = 0;
	    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
	    res.add(new ArrayList<Integer>());
	    System.out.print("for(int n : [");
	    for(int n : num)
	    	System.out.print(n+",");
	    System.out.println("]");
	    
	    for (int n : num) {
	        int size = res.size();
	        System.out.println("  size = "+size);
	        System.out.println("  for("+size+" to 1)");
	        for (; size > 0; size--) {
	            List<Integer> r = res.pollFirst();
	            System.out.print("    r = ");
	            System.out.println(r);
	            System.out.println("    for (0 to "+r.size()+")");
	            for (int i = r.size(); i >= 0; i--) {
	                List<Integer> t = new ArrayList<Integer>(r);
	                System.out.print("      t = ");
	                System.out.println(t);
	                
	                t.add(i, n);
	                System.out.println("      t.add("+i+", "+n+")");
	                
	                res.add(t);
	                System.out.print("      res.add -> ");
	                System.out.println(t);
	                
	                System.out.println("      -------");
	                
	                c++;
	            }
	        }
	    }
	    return res;
	}
	
	
	
	
	/*public static void permutateIter(String value){
		int len = value.length();
		
		for(int i = 0; i < len; i++){
			char prefix = value.charAt(i);
			for(int j = 0; j < len; j++){
				StringBuilder result = new StringBuilder();
				result.append(value.substring(0, j));
				result.append(value.charAt(j));
				result.append(prefix);
				result.append(value.substring(j+1));
				
				
				System.out.println(result.toString());
				if(value.charAt(j) == prefix){
					
					continue;
				}
				StringBuilder result = new StringBuilder();
				result.append(value.substring(0, j));
				result.append(prefix);
				result.append(value.substring(j+1));
				System.out.println(result.toString());
			}
		}
		
	}*/
	
	
	
	
	
	
	
	public static void permutate2(int[] res){
		c = 0;
		permutate2(res, res.length);
	}
	
	
	static List<List<Integer>> list = new ArrayList<List<Integer>>();
	private static void permutate2(int[] res, int len){
		if(len == 0){
			List<Integer> listLocal = new ArrayList<Integer>();
			for(int x : res)
				listLocal.add(x);
			list.add(listLocal);
				//System.out.print(x);
			//System.out.println();
			c++;
		} else {
			for(int i = 0; i < len; i++){
				swap(res, i, len-1);
				permutate2(res, len-1);
				swap(res, i, len-1);
			}
			/* for(0 to 2)
			 *  swap([1,2], 0, 1) -> 2,1
			 *  permutate([2,1], 1)
			 *  	swap([2,1], 0, 0) -> 1,2
			 *  	sysout [1,2]
			 *  	
			 * 
			 */
		}
		
	}
	
	private static void swap(int[] res, int i, int j){
		int tmp = res[i];
		res[i] = res[j];
		res[j] = tmp;
	}


}