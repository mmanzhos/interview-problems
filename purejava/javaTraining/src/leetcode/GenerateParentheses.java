package leetcode;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

	
	public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String building, int opened, int closed, int n) {
        // stop recursion if...
        if (building.length()/2 == n) {
            result.add(building);
            return;
        }
        
        
        if (opened < n)
            backtrack(result, building + "(", opened + 1, closed, n);
        if (closed < opened)
            backtrack(result, building + ")", opened, closed + 1, n);
        
        
    }
	
}
