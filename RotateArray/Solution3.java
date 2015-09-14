public class Solution3 {

    public void rot(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
        	return ;
        }
        k = k % nums.length;
        rot(nums, 0, nums.length - k - 1);
        rot(nums, nums.length - k, nums.length - 1);
        rot(nums, 0, nums.length - 1);

        return;
    }

    public static void main(String[] args) {
    	Solution3 sol = new Solution3();
    	int[] nums = {1, 2, 3, 4, 5, 6, 7};
    	sol.rotate(nums, 3);
    	for (int i: nums) {
    		System.out.println(i);
    	}
    }
}