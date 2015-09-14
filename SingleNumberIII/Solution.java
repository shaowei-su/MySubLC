public class Solution {
    public int[] singleNumber(int[] nums) {
    	int[] res = new int[2];
        if (nums == null || nums.length == 0) {
        	return res;
        }
        int n = 0;
        res[0] = 0;
        res[1] = 0;
        for (int i = 0; i < nums.length; i++) {
        	n ^= nums[i];
        }

        n = n & (~(n - 1));
        for (int i = 0; i < nums.length; i++) {
        	if ((nums[i] & n) != 0) {
        		res[0] ^= nums[i];
        	} else {
        		res[1] ^= nums[i]; 
        	}
        }

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {1, 2, 2, 3, 4, 4, 5, 3};
    	int[] res = sol.singleNumber(nums);
    	for (int i: res) {
    		System.out.println(i);
    	}
    }
}