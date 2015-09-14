public class Solution2 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
        	return ;
        }

        int[] rot = new int[nums.length];
        k = k % nums.length;
        for (int i = 0; i < nums.length; i++) {
            rot[i] = nums[(nums.length - k + i) % nums.length];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rot[i];
        }
        return ;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] nums = {1, 2, 3, 4, 5, 6, 7};
    	sol.rotate(nums, 3);
    	for (int i: nums) {
    		System.out.println(i);
    	}
    }
}