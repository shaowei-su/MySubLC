public class Solution {
    public int maxProduct(int[] nums) {
        //brute force
        if (nums == null || nums.length == 0) {
        	return 0;
        }

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
        	int local = nums[i];
        	for (int j = i + 1; j < nums.length; j++) {
        		// if (local * nums[j] < local) {
        		// 	break;
        		// } else {
        		// 	local *= nums[j];
        		// }

        		//above is wrong !!!!
        		//two minus is possibly a maximum!!

        		//should calculate all possible sub-array and find the maximum
        	}

        	max = Math.max(max, local);
        }

        return max;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {2, 3, -2, 4};
    	System.out.println(sol.maxProduct(nums));
    }
}