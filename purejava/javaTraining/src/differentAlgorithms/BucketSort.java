package differentAlgorithms;

public class BucketSort {

	public static void sort(int[] array, int min, int max) {
		int[] buckets = new int[max - min + 1];
		
		for (int i = 0; i < array.length; i++) {
			buckets[array[i]-min]++;
		}
		
		int pos = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i]; j++) {
				array[pos++] = i + min;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {3, 1, 3, 2, 3, 1, 2, 2, 3, 1, 2, 3, 2, 1, 1};
		sort(array, 1, 3);
		for (int n : array) System.out.print(n + ", ");
	}

}
