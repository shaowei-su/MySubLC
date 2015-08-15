public class Solution2 {
    public void sortColors(int[] nums) {
        //edge cases
        if (nums == null || nums.length == 0) {
        	return ;
        }

        //separate 0 and 1/2
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
        	if (nums[left] != 1 && nums[left] != 2) {
        		left++;
        		continue;
        	}
        	if (nums[right] != 0) {
        		right--;
        		continue;
        	}
        	int temp = nums[right];
        	nums[right] = nums[left];
        	nums[left] = temp;
        }
        //separate 1 and 2
        left = right;
        right = nums.length - 1;
        while (left < right) {
        	if (nums[left] != 2) {
        		left++;
        		continue;
        	}
        	if (nums[right] != 1) {
        		right--;
        		continue;
        	}
        	int temp = nums[right];
        	nums[right] = nums[left];
        	nums[left] = temp;
        }

        return;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] nums = {0, 2, 1, 0, 2, 1};
    	sol.sortColors(nums);
    	for (int i: nums) {
    		System.out.println(i);
    	}
    }


}