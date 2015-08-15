public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0 || nums == null) {
        	return 0;
        }

        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
        	for (int j = 0; j < nums.length; j++) {
        		bits[i] += (nums[j] >> i) & 1; // 将每个数同一位求和
        	}
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
        	res += (bits[i] % 3) << i; // 求和结果%3
        }

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {1, 2, 3, 1, 2, 1, 2};
    	System.out.println(sol.singleNumber(nums));
    }
}