package variousAlgorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class HeapSort {

	private static int N;
	
	public static void sort(int[] array) {
		heapify(array);
		for (int i = N; i > 0; i--) {
			//System.out.println("Swap: " + array[0] + " and " + array[i]);
			swap(array, 0, i);
			N = N - 1;
			//maxheap(array, 0);
			minheap(array, 0);
		}
	}
	
	public static void sort2(int[] array) {
		heapify2(array);
		for (int i = N; i > 0; i--) {
			//System.out.println("Swap: " + array[0] + " and " + array[i]);
			swap(array, 0, i);
			N = N - 1;
			//maxheap(array, 0);
			minheap2(array, 0);
		}
	}
	
	private static void heapify(int[] array) {
		N = array.length - 1;
		for (int i = N/2; i >= 0; i--) {
			//maxheap(array, i);
			minheap(array, i);
		}
		//System.out.println("\nHeapified:-------------\n");
		//for (int n : array) System.out.print(n + ", ");
		//System.out.println();
		
		/* 15, 9, 2, 8, 1, 0, 3, 5 - maxheap
		 *            15
		 *            /\
		 *           /  \
		 *          9    2
		 *         /\    /\ 
		 *        8  1  0  3
		 *       /
		 *      5  
		 * 0, 1, 2, 5, 8, 3, 9, 15 - minheap
		 *             0
		 *            /\
		 *           /  \
		 *          1    2
		 *         /\    /\ 
		 *        5  8  3  9
		 *       /
		 *      15
		 * */
		
		
	}
	
	private static void heapify2(int[] array) {
		N = array.length - 1;
		for (int i = N/2; i >= 0; i--) {
			minheap2(array, i);
		}
		//System.out.println("\nHeapified:-------------");
		//for (int n : array) System.out.print(n + ", ");
		//System.out.println();
		//System.out.println();
	}
	
	private static void printAsTree(int[] array) {
		System.out.println("------------");
		System.out.println("    " + array[0]);
		System.out.println("  " + array[1] + "   " + array[2]);
		System.out.println(" " + array[3] + " " + array[4] + " " + array[5] + " " + array[6]);
		System.out.println("------------");
	}
	
	
	private static void maxheap(int[] array, int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;
		if (left <= N && array[left] > array[i]) {
			max = left;
		}
		if (right <= N && array[right] > array[max]) {
			max = right;
		}
		if (max != i) {
			swap(array, i, max);
			maxheap(array, max);
		}
	}
	
	private static void minheap(int[] array, int i) {
		//printAsTree(array);

		//System.out.println("Minheap call, i = "+ i);
		int left = 2 * i;
		//System.out.println("\tleft = " + left);
		int right = 2 * i + 1;
		//System.out.println("i = " + i + " element = " + array[i]);
		//if (left <= N && right <= N)
			//System.out.println("left = " + left + " element = " + array[left] + " right = " + right + " element = " + array[right]);
		
		int min = i;
		if (left <= N && array[left] < array[min]) {
			min = left;
			//System.out.println("\t\tmin = left =" + left);
		}
		if (right <= N && array[right] < array[min]) {
			min = right;
			//System.out.println("\t\tmin = right =" + right);
		}
		
		
		
		if (min != i) {
			//System.out.println("\t\tSwap: " + array[i] + " and " + array[min]);
			swap(array, i, min);
			minheap(array, min);
		}
	}
	
	private static void minheap2(int[] array, int i) {
		//printAsTree(array);

		//System.out.println("Minheap call, i = "+ i);
		int left = 2 * i + 1;
		//System.out.println("\tleft = " + left);
		int right = 2 * i + 2;
		//System.out.println("i = " + i + " element = " + array[i]);
		//if (left <= N && right <= N)
			//System.out.println("left = " + left + " element = " + array[left] + " right = " + right + " element = " + array[right]);
		
		int min = i;
		if (left <= N && array[left] < array[min]) {
			min = left;
			//System.out.println("\t\tmin = left =" + left);
		}
		if (right <= N && array[right] < array[min]) {
			min = right;
			//System.out.println("\t\tmin = right =" + right);
		}
		
		
		
		if (min != i) {
			//System.out.println("\t\tSwap: " + array[i] + " and " + array[min]);
			swap(array, i, min);
			minheap2(array, min);
		}
	}
	



	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
		
		
	}

	
	
	public static void heapSortPQ(int[] array) {
		
		Comparator comp = new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				if (x < y) return 1;
				if (x > y) return -1;
				return 0;
			}
		};
		
		// Java's PriorityQueue class functions as a min heap
	    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(array.length, Collections.reverseOrder());
	    
	    // Add each array element to the heap
	    for (Integer n : array)
	        heap.add(n);
	    
	    // Elements come off the heap in ascending order
	    for (int i = 0; i < array.length; i++)
	        array[i] = heap.remove();
	}
	
	
	public static void main(String[] args) {
		int SIZE = 1000000;
		int[] array = new int[SIZE];
		Random rand = new Random();
		for (int i = 0; i < SIZE; i++) {
			array[i] = rand.nextInt(SIZE);
		}
		//int [] array = {8, 3, 1, 5, 2, 0, 9};
		
		
		long start = System.currentTimeMillis();
		sort(array);
		//for (int n : array) System.out.print(n + ", ");
		System.out.println("\n" + (System.currentTimeMillis() - start) + " ms");
		
		start = System.currentTimeMillis();
		sort2(array);
		//heapSortPQ(array);
		System.out.println("\n" + (System.currentTimeMillis() - start) + " ms");
		
		//for (int n : array) System.out.print(n + ", ");
		
	}

}
