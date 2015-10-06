package leetcode;

import java.util.Arrays;

public class UglyNumber {

	public boolean isUgly(int num) {
        if (num < 1) return false;
        if (num == 1) return true;
        // 14
        while (num > 1) {
            int initially = num;
            if (num % 5 == 0) num /= 5;
            if (num % 3 == 0) num /= 3;
            if (num % 2 == 0) num /= 2;
            if (initially == num) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		int num = 2;
		UglyNumber solver = new UglyNumber();
		for (int n : new int[]{1,2,3,4,5,6,7,8,14,30}) {
			System.out.println(n + " " + solver.isUgly(n));	
		}
	}
}
