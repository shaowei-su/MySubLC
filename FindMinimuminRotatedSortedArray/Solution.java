public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return -1;
        }
        if (nums.length == 1) {
        	return nums[0];
        }
        if (nums.length == 2) {
        	return nums[0] < nums[1] ? nums[0] : nums[1];
        }
        for (int i = 1; i < nums.length -1; i++) {
        	if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
        		return nums[i];
        	}
        }

        return nums[0] < nums[nums.length - 1] ? nums[0] : nums[nums.length - 1];
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {4, 5, 6, 7, 0, 1, 2};
    	System.out.println(sol.findMin(nums));
    }
}