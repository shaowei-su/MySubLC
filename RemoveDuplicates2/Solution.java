public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
        	return -1;
        }
        if (nums.length < 3) {
        	return nums.length;
        }

        int[] copy = new int[nums.length];
        copy[0] = nums[0];
        copy[1] = nums[1];
        int copyIndex = 2;
        for (int i = 2; i < nums.length; i++) {
        	if (nums[i] != copy[copyIndex - 1] || nums[i] != copy[copyIndex - 2]) {
        		copy[copyIndex] = nums[i];
        		copyIndex++;
        	}
        }

        for (int i = 2; i < copyIndex; i++) {
        	nums[i] = copy[i];
        }

        return copyIndex;

    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {1, 1, 1, 1, 2, 2, 3};
    	int r = sol.removeDuplicates(nums);
    	for (int i = 0; i < r; i++) {
    		System.out.println(nums[i]);
    	}
    }
}