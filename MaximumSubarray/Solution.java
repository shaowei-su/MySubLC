public class Solution {
    public int maxSubArray(int[] nums) {
        //edge cases
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                max = Math.max(max, sum[j] - sum[i]);
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sol.maxSubArray(nums));
    }
}