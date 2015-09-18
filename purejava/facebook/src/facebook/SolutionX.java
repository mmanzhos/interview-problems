package facebook;


public class SolutionX {

	static int[] tmp;
	
	public static void sort(int[] array) {
		tmp = new int[array.length];
		mergeSort(array, 0, array.length - 1);
	}
	
	private static void mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int mid = (high - low) / 2  + low;
			mergeSort(array, low, mid);
			mergeSort(array, mid+1, high);
			mergeBack(array, low, mid, high);
		}
	}
	
	
	private static void mergeBack(int[] array, int low, int mid, int high) {
		for (int i = low; i <= high; i++)
			tmp[i] = array[i];
		
		int i = low; 
		int k = low;
		int j = mid + 1;
		
		for (; i <= mid && j <= high;)
			array[k++] = tmp[i] < tmp[j] ? tmp[i++] : tmp[j++];
		
		for (; i<= mid;)
			array[k++] = tmp[i++];
		
	}
	
	
	public static void qSort(int[] array) {
		quickSort2(array, 0, array.length - 1);
	}
	
	public static void quickSort2(int[] arr, int low, int high) {
		int i = low;
		int j = high;
		int pivot = j;

		while (i <= j) {
			while (arr[pivot] < arr[j]) {
				j--;
			}
			while (arr[i] < arr[pivot]) {
				i++;
			}
			/*if (i < j) {
				swap(arr, i, j);
			}*/
			
			// should be true
			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}

		

		if (low < j)
			quickSort2(arr, low, j);
		if (i < high)
			quickSort2(arr, i, high);

	}
	
	private static void quickSort(int[] array, int low, int high) {
		int i = low;
		int j = high;
		
		int pivot = array[low];
		//https://www.youtube.com/watch?v=2DK8qMHhqkE
		//http://www.java2novice.com/java-sorting-algorithms/quick-sort/
		// 5, 2, 6, 1, 3, 4
		while (i <= j) {
			System.out.println("i=" + i + " j=" + j);
			while (array[i] < pivot) {
				i++;
				System.out.println("i++");
			}
			while (array[j] > pivot) {
				j--;
				System.out.println("j--");
			}
			if (i <= j) {
				System.out.println("swap ar[" + i + "] "+ array[i] +" and ar[" + j + "] " + array[j]);
				swap(array, i, j);
				i++;
				j--;
			}
		}
		
		System.out.println("--- out of loop ---");
		
		if (low < j)
			quickSort(array, low, j);
		if (i < high)
			quickSort(array, i, high);
		
	}
	
	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}


	public static void main(String[] args) {
		
		int[] ar = {5, 2, 6, 1, 3, 4};
		// expected: 4, 11, 23, 28, 43, 45, 65, 89, 98
		qSort(ar);
		for (int n : ar) {
			System.out.print(n + ", ");
		}
		
	}

}
