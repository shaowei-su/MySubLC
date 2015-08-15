public class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
        	if (count == 0) {
        		res = nums[i];
        		count++;
        	} else if (res == nums[i]) {
        		count++;
        	} else if (res != nums[i]) {
        		count--;
        	}
        }

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {1, 2, 3, 1, 1, 3};
    	System.out.println(sol.majorityElement(nums));
    }
}