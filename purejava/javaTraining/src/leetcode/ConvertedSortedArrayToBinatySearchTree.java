package leetcode;



public class ConvertedSortedArrayToBinatySearchTree {

	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return treeBuilder(nums, 0, nums.length);
    }
    
    private TreeNode treeBuilder(int[] nums, int low, int high) {
        if (low >= high) 
            return null;
        int mid = (high - low) / 2 + low;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = treeBuilder(nums, low, mid);
        root.right = treeBuilder(nums, mid+1, high);
        return root;
    }

}
