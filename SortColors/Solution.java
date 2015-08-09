import java.util.*;

public class Solution {
    public void sortColors(int[] nums) {
        //edge cases
        if (nums == null || nums.length == 0) {
        	return ;
        }

        int[] res = new int[nums.length];
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
        	count[nums[i]]++;
        }

        for (int i = 1; i < 3; i++) {
        	count[i] = count[i] + count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
        	res[count[nums[i]] - 1] = nums[i];
        	count[nums[i]]--;
        }

        System.arraycopy(res, 0, nums, 0, nums.length);
    }
}