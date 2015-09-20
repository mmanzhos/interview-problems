package tests;

public class Test_MergeSort {


	int[] tmp;

	/*
	4 3 6 1
	4 3 -- 6 1
	4 -- 3 -- 6 -- 1


	*/


	private static int[] mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = (high - low) / 2 + low;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
		}

		merge(arr, low, high);
	}

	// what does this function do?
	/*
	arr = [4, 3]
	low = 0
	high = 2

	tmp 

	*/
	private static void merge(int[] arr, int low, int high) {
		int i = low;
		int mid = (high - low) / 2 + low ;
		int j = mid + 1;
		int k = low;

		/*
				    i     j
		array = {[2, 4], [9]}
		i = 0
		j = 2
		mid = 1
		k = 0
		*/

		while (j <= high && i <= mid) {
			if (arr[i] < arr[j]) {
				tmp[k] = arr[i];
				i++;
			} else {
				tmp[k] = arr[j];
				j++;
			}
			k++;
		}

		for (; i <= mid; i++) {
			tmp[k] = arr[i];
			k++;
		}
		for (; j <= high; j++ ) {
			tmp[k] = arr[j];
			k++;
		}
	}
	
	public static int[] mergeSort(int[] arr) {
		int length = arr.length;
		tmp = new int[length];
		
		mergeSort(arr, 0, length-1);
		
		return tmp;
	}
	
	public static void main(String[] args) {
		int[] array = {4, 3, 7, 22, 15, 6, 3};
		array = mergeSort(array);
		for (int n : array) {
			System.out.print(n + ", ");
		}
	}

}
