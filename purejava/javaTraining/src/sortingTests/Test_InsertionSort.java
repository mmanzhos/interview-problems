package sortingTests;

public class Test_InsertionSort {

	public static void insertionSort(int[] arr) {
		int len = arr.length;
		
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
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
		int[] arr = {3, 6, 1, 2, 9, 7, 10, 15};
		insertionSort(arr);
		for (int n : arr) System.out.print(n + " ");
	}

}
