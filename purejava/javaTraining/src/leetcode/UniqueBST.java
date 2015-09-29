package leetcode;

public class UniqueBST {
	
	
    /*
    I read idea is following: for root #X multiply left and right subtres
    Left = i - 1
    Right = n - i
    G(0) = 1
    G(1) = 1
    don't understand :(
    G(2) = G(0)*G(2-1) + G(1)*G(2-2)
    
    Wow, I got it.
    I draw a table:
    
    () means count amount of numbers inside
    each time in 2nd row I pick another possible next root and separate subtrees on left and right
    c[0] or empty subtree is ignored, because multipling on it (1) doesn't change result
    
    0 | 1 |      12      |         123              |               1234
    --------------------------------------------------------------------------------------------
    1 | 1 | 1(2)   (1)2  | 1(23)   (1)2(3)   (12)3  | 1(234)    (1)2(34)     (12)3(4)     (123)4
    ---------------------------------------------------------------------------------------------
    1 | 1 | c[1] + c[1]  | c[2] + c[1]*c[1] + c[2]  | c[3]   +  c[1]*c[2]  +  c[2]*[c1]  + c[3]
    
    
    */
	
	
	public int numTrees(int n) {
        if (n < 2) return 1;
        int[] solution = new int[n+1];
        solution[0] = 1;
        solution[1] = 1;
        
        for (int tree = 2; tree <= n; tree++) {
            int result = 0;
            for (int i = 1; i <= tree; i++) {
                int left = solution[i-1];
                int right = solution[tree-i];
                result += left * right;
            }
            solution[tree] = result;
        }
        
        return solution[n];
    }

}
