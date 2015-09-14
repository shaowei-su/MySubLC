public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
        	return Integer.MIN_VALUE;
        }

        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}