package tests;

public class Test_BubbleSort {

	public static void bubbleSort(int[] arr) {
		int len = arr.length;
		boolean wasSwap = false;
		
		for (int i = 0; i < len; i++) {
			if (i == 1 && wasSwap == false) return; 
			for (int j = 1; j < len - i; j++ ) {
				if (arr[j-1] > arr[j]) {
					swap(arr, j-1, j);
					wasSwap = true;
				}
			}
		}
		
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {3, 5, 1, 9, 4, 2};
		bubbleSort(arr);
		for (int n : arr) {
			System.out.print(n + " ");
		}
	}

}
