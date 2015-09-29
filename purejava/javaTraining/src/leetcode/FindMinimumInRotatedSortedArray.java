package leetcode;



public class FindMinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
        /*
        It needs description.
        1) Find middle element
        2) If first < last than there is no rotation
        -) 7012456
        -) 4567012
        3) if first element > middle than minimum in left half
        4) if first element < middle than minimum in right half
        */
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            
            if (nums[low] < nums[high]) return nums[low];
            
            int mid = (high - low) / 2 + low;
            
            if (nums[low] <= nums[mid]) {
                low = mid+1;
            } else {
                high = mid;
            }
            
        }
        
        return nums[low];
    }

}
