package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        /*
        1. Iterate over 1 to target. This is a way to "build" solution
        2. In each target iterate over each array elements (candidates)
        2.1 With additional pruning condition, which also will save us from IndexOutOfBounds, element should be less than current target
        3. Special condition: if element equals to target, add it to separate list
        4. Sum up possible solutions:
        4.1 Iterate over each list in solution # (currentTarget - element). 
            So if target is 5, and list is [2,3] we will check possible building elements [5-2, 5-3]
            this method also leaves empty lists on some elements which are impossible to build (like 1 in above example)
        4.2 Add to a new list only if candidateElement <= first element in current list (from 4.1)
        4.2.1 Firstly add candidateElement to a new list, then add other elements from current list
        */
        
        List<List<List<Integer>>> dp = new ArrayList<>();
        Arrays.sort(candidates);
        
        for (int i = 1; i <= target; i++) {
            
        
        	
            List<List<Integer>> result = new ArrayList<>();
            
            
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                int element = candidates[j];
                
                if (element == i) {
                    result.add(Arrays.asList(element));
                } else {
                    for (List<Integer> list : dp.get(i - element - 1)) {
                        if (element <= list.get(0)) {
                            List<Integer> newList = new ArrayList<>();
                            newList.add(element);
                            newList.addAll(list);
                            result.add(newList);
                        }
                    }
                }
                
            }
            
            dp.add(result);
        }
        return dp.get(target-1);
    }

	
	
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n) return result;
        
        backtrack(result, new LinkedList<Integer>(), 1, n, k);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, LinkedList<Integer> list, int fromNumber, int n, int k) {
        if (list.size() == k) {
            result.add(list);
            return;
        }
        
        for (int i = fromNumber; i <= n; i++) {
            LinkedList<Integer> newList = new LinkedList<Integer>(list);
            newList.add(i);
            backtrack(result, newList, i + 1, n, k);
        }
        
    }
    
	
	
	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		Combinations combo = new Combinations();
		System.out.println(combo.combine(n, k));
	}

}
