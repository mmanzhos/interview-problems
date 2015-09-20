package tests;

public class Test_SelectionSort {

	public static void selectionSort(int[] arr) {
		int len = arr.length;
		int minIndex = 0;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 6, 1, 2, 9, 7, 10, 15};
		bubbleSort(arr);
		for (int n : arr) System.out.print(n + " ");
	}

}
