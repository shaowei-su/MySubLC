public class Solution {

	public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
        	return ;
        }

        for (int i = 0; i < k; i++) {
        	for (int j = nums.length - 1; j > 0; j--) {
        		swap(nums, j, j - 1);
        	}
        }

        return ;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {1, 2, 3, 4, 5, 6, 7};
    	sol.rotate(nums, 3);
    	for (int i: nums) {
    		System.out.println(i);
    	}
    }
}