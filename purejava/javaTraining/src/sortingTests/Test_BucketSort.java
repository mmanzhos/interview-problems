package sortingTests;

public class Test_BucketSort {

	public static void bucketSort(int[] arr) {
		int len = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < len; i++) {
			min = arr[i] < min ? arr[i] : min;
			max = arr[i] > max ? arr[i] : min;
		}

		int[] buckets = new int[max - min + 1];
		
		for (int i = 0; i < len; i++) {
			int val = arr[i];
			buckets[val - min]++;
		}

		int counter = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i]; j++) {
				arr[counter++] = i + min;
			}
		}



	}
	
	public static void main(String[] args) {
		int[] arr = {3, 4, 3, 5, 3, 4, 5, 3, 5};
		bucketSort(arr);
		for (int n : arr) System.out.print(n + " ");
	}

}
