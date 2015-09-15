package javaTraining;

import java.util.Stack;

/**
 * Pseudo code:
 * 
 * capacity
 * weight []
 * value []
 * T [][]
 * 
 * j for 0 to capacity
 *   if j is >= than weight of 1st row with index 0 (weight[0])
 *   	set T[0][j] to value[0]
 * 
 * i for 1 to elements
 *   j for 1 to capacity
 *   	if j is < weight[i]
 *   		set T[i][j] to the same capacity maximum value of previous row (T[i-1][j])
 *   	else
 *   		set T[i][j] to maximum element of:
 *   			: T[i-1][j] or
 *   			: T[i-1][j-weight[i]] + value[i] == maximum value of remainder capacity of previous row
 * 
 *
 *	print last element of T == T[elements][capacity]
 *
 *
 */


public class KnapsackDP {

	public static void main(String[] args) {

		int capacity = 7;
		int[] weight = {1, 3, 4, 5};
		int[] value = {1, 4, 5, 7};
		
		int[][] T = new int[weight.length][capacity+1];

		// set first row
		for (int j = 0; j <= capacity; j++) {
			if (j >= weight[0]) {
				T[0][j] = value[0];
			}
		}
		
		
		// calculations
		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j <= capacity; j++) {
				if (j < weight[i]) {
					T[i][j] = T[i-1][j];
				} else {
					T[i][j] = Math.max(T[i-1][j-weight[i]] + value[i], T[i-1][j]);
				}
			}
		}
		
		
		// print out matrix
		for (int i = 0; i < T.length; i++) {
			for (int j = 0; j <= capacity; j++) {
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		System.out.println("\nResult:\n" + T[T.length-1][T[0].length-1]);
		
		
		
		System.out.println("\nLet's find weights of used elements!");
		
		int[] marked = new int[]{weight.length-1, capacity};
		Stack<Integer> result = new Stack<Integer>();
		
		for (int i = weight.length - 1; i >= 1; i++) {
			if (T[marked[0]][marked[1]] == T[marked[0]-1][marked[1]]) {
				marked = new int[]{marked[0]-1, marked[1]};
			} else {
				result.push(weight[marked[0]]);
				if (marked[1] - weight[marked[0]] <= 0) {
					break;
				}
				marked = new int[]{marked[0]-1, marked[1] - weight[marked[0]]};
			}
		}
		
		System.out.println(result.toString());
		
		
	}

}
