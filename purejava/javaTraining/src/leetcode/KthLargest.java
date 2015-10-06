package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {

	public int findKthLargest(int[] nums, int k) {

		// quick sort
		int i = 0;
		int j = nums.length - 1;
		int pivot = nums.length - k;

		while (i <= j) {

			while (nums[pivot] <= nums[j] && j > pivot) {
				j--;
			}
			while (nums[i] <= nums[pivot] && i < pivot) {
				i++;
			}

			if (i < j) {
				swap(nums, i, j);
				i = 0;
				j = nums.length - 1;
			} else if (i == j) {
				break;
			}

		}

		return nums[nums.length - k];
	}

	PriorityQueue<Integer> q = new PriorityQueue<>(2, Comparator.reverseOrder());
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;
	}

	public static void main(String[] args) {
		KthLargest k = new KthLargest();
		int[] ar = { 3, 2, 1, 5, 6, 4 };
		k.findKthLargest(ar, 2);
		for (int n : ar) {
			System.out.print(n + " ");
		}
	}
}
