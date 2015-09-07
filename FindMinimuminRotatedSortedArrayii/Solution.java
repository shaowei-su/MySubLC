public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return -1;
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] < res) {
        		res = nums[i];
        	}
        }

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {4, 5, 6, 7, 0, 1, 2};
    	System.out.println(sol.findMin(nums));
    }
}