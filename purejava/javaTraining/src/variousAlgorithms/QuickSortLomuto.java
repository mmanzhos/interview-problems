package variousAlgorithms;

public class QuickSortLomuto {

	
	private int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (nums[j] <= pivot) {
				swap(nums, i, j);
				i++;
			}
		}
		swap(nums, i, high);
		return i;
	}
	
	public void quickSort(int[] nums, int low, int high) {
		if (low < high) {
			int p = partition(nums, low, high);
			quickSort(nums, low, p - 1);
			quickSort(nums, p + 1, high);
		}
	}	
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	
	public static void main(String[] args) {
		QuickSortLomuto qsl = new QuickSortLomuto();
		int[] array = {3,5,4,2,6,8,4,6,8,3,6,4,3};
		qsl.quickSort(array, 0, array.length-1);
		for (int n : array) {
			System.out.print(n + " ");
		}
	}

}
