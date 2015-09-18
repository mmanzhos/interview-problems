package variousAlgorithms;

public class InsertionSort {

	// 5, 2, 8, 3
	public static void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j-1]) {
					int tmp = array[j];
					array[j] = array[j-1];
					array[j-1] = tmp;
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
