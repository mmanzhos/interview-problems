package sortingTests;

public class Test_HeapSort {

	int N;
	
	public void sort(int[] array) {
		heapify(array);
		for (int i = N; i > 0; i--) {
			swap(array, 0, i);
			N--;
			minheap(array, 0);
		}
	}
	
	
	private void heapify(int[] array) {
		N = array.length - 1;
		for (int i = N/2; i >= 0; i--) {
			minheap(array, i);
		}
	}


	private void minheap(int[] array, int i) {
		/*
		 *    8
		 *  3   1
		 * 5 2 0 9
		 *
		 * */
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int min = i;
		
		if (left <= N && array[left] < array[min]) {
			min = left;
		}
		if (right <= N && array[right] < array[min]) {
			min = right;
		}
		
		if (min != i) { // if there was a child less than parent
			swap(array, i, min);
			minheap(array, min);
		}
	}


	private void swap(int[] array, int i, int min) {
		// swap a=4 and b=5
		// a = b - a; a = 5 - 4 = 1
		// b = b - a; b = 5 - 1 = 4
		// a = a + b; a = 1 + 4 = 5
		int tmp = array[i];
		array[i] = array[min];
		array[min] = tmp;
		
		/*array[i] = array[min] - array[i];
		array[min] = array[min] - array[i];
		array[i] = array[min] + array[i];*/
	}


	public static void main(String[] args) {
		Test_HeapSort sorting = new Test_HeapSort();
		int[] array = {8, 3, 1, 5, 2, 0, 9};
		sorting.sort(array);
		for (int n : array)
			System.out.print(n + " ");
		System.out.println();
	}

}
