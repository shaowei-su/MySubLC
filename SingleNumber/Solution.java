public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }

        int single = 0;
        for (int i = 0; i < nums.length; i++) {
        	single ^= nums[i];
        }

        return single;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {1, 2, 3, 1, 3};
    	System.out.println(sol.singleNumber(nums));
    }
}