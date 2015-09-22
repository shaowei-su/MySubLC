public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }

        int retval = 0;
        for (int i = 0; i < nums.length; i++) {
        	retval ^= i;
        	retval ^= nums[i];
        }

        retval ^= nums.length;

        return retval;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {0, 1, 3};
    	System.out.println(sol.missingNumber(nums));
    }
}