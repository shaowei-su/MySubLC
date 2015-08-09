public class Solution2 {
    public int removeDuplicates(int[] nums) {
 		if (nums == null || nums.length == 0) {
 			return 0;
 		}

 		int idx = 0;
 		int count = 0;

 		for (int i = 0; i < nums.length; i++) {
 			if (i > 0 && nums[i] == nums[i - 1]) {
 				count++;
 				if (count > 2) {
 					continue;
 				}
 			} else {
 				count = 1;
 			}

 			nums[idx++] = nums[i];
 		}

 		return idx;

    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] nums = {1, 1, 1, 1, 2, 2, 3};
    	int r = sol.removeDuplicates(nums);
    	for (int i = 0; i < r; i++) {
    		System.out.println(nums[i]);
    	}
    }
}