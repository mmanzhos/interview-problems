package ctciTest;

public class BinarySearch {

	public int binarySearch(int[] array, int element) {
		int low = 0;
		int end = array.length;
		while (low < end) {
			int mid = (end - low) / 2 + low;
			if (array[mid] == element) return mid;
			else if (element < array[mid])
				end = mid;
			else if (element > array[mid])
				low = mid + 1;
		}
		return low;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearch bs = new BinarySearch();
		int[] array = {1, 2, 3, 5, 9, 9, 9, 14, 15, 19, 20};
		int index = bs.binarySearch(array, 1);
		System.out.println(index);
	}

}
