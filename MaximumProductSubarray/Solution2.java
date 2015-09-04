public class Solution2 {
    public int maxProduct(int[] nums) {
        //brute force
        if (nums == null || nums.length == 0) {
        	return 0;
        }

        int global = nums[0];
        int localMin = nums[0];
        int localMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = localMax;
            localMax = Math.max(Math.max(localMax * nums[i], nums[i]), localMin * nums[i]);
            localMin = Math.min(Math.min(localMin * nums[i], nums[i]), temp * nums[i]);
            global = Math.max(global, localMax);
        }

        return global;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] nums = {2, 3, -2, 4};
    	System.out.println(sol.maxProduct(nums));
    }
}