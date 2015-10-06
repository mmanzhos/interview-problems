package variousAlgorithms;

public class QuickSortLomutoKthLargest {

	// https://www.youtube.com/watch?v=8hHWpuAPBHo
	int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
		int r = right;
        while (l <= r) {
            if (nums[l] > pivot && nums[r] < pivot)
                swap(nums, l++, r--);
            if (nums[l] <= pivot) l++; 
            if (nums[r] >= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        k = nums.length - k + 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos == k - 1) return nums[pos];
            if (pos > k - 1) right = pos - 1;
            else left = pos + 1;
        }
    }
	
	
	public static void main(String[] args) {
		QuickSortLomutoKthLargest qsl = new QuickSortLomutoKthLargest();
		int[] array = {3, 2, 1, 6, 4, 5};
		System.out.println(qsl.findKthLargest(array, 2));
		for (int row : array) {
			System.out.print(row + " ");
		}
		
	}

}
