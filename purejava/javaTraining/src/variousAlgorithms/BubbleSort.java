package variousAlgorithms;

public class BubbleSort {

	public static void sort(int[] array) {
		boolean noSwaps = true;
		for (int i = 0; i < array.length; i++) {
			if (i == 1 && noSwaps) return;
			for (int j = 1; j < array.length - i; j++) {
				if (array[j-1] > array[j] ) {
					noSwaps = false;
					int tmp = array[j-1];
					array[j-1] = array[j];
					array[j] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {8, 7, 5, 3, 2, 1};
		sort(array);
		for (int n : array) System.out.print(n + ", ");
	}

}
