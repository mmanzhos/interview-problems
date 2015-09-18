package tests;

public class Test_MergeSort {


	static int[] tmp;

	/*
	4 3 6 1
	4 3 -- 6 1
	4 -- 3 -- 6 -- 1


	*/


	private static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (high - low) / 2 + low;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	// what does this function do?
	/*
	arr = [4, 3]
	low = 0
	high = 2

	tmp 

	*/
	private static void merge(int[] arr, int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			tmp[i] = arr[i];
		}
		
		int i = low;
		int j = mid + 1;
		int k = low;
		
		System.out.println("Initial view");
		for (int m = low; m <= high; m++) {
			System.out.print(arr[m] + " ");
		}
		System.out.println();
		
		/*
				    i     j
		array = {[15, 6], [3]}
		i = 0
		j = 2
		mid = 1
		k = 0
		*/

		
		for (; i <= mid && j <= high;)
			arr[k++] = tmp[i] < tmp[j] ? tmp[i++] : tmp[j++];
			
		/*while (j <= high && i <= mid) {
			if (tmp[i] < tmp[j]) {
				arr[k] = tmp[i];
				i++;
			} else {
				arr[k] = tmp[j];
				j++;
			}
			k++;
		}*/

		for (; i <= mid; i++, k++)
			arr[k] = tmp[i];
		
		System.out.println("After merging");
		for (int m = low; m <= high; m++) {
			System.out.print(arr[m] + " ");
		}
		System.out.println();
		
		
	}
	
	public static void mergeSort(int[] arr) {
		int length = arr.length;
		tmp = new int[length];
		mergeSort(arr, 0, length-1);
	}
	
	public static void main(String[] args) {
		int[] array = {4, 3, 7, 22, 15, 6, 3};
		mergeSort(array);
		for (int n : array) {
			System.out.print(n + ", ");
		}
	}

}
