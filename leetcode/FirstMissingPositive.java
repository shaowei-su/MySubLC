package leetcode;

import java.util.Arrays;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
    	//edge cases
    	if (nums == null || nums.length == 0) {
    		return 1;
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] < nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]) {
    			int temp = nums[nums[i] - 1];
    			nums[nums[i] - 1] = nums[i];
    			nums[i] = temp;
    			i--; // the new content switched back also needs check !!!! so i--
    		}
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] != i + 1) {
    			return  i + 1;
    		}
    	}
    	
    	return nums.length + 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstMissingPositive f = new FirstMissingPositive();
		int[] nums = {-1, 1, 3, 4};
		int r = f.firstMissingPositive(nums);
		System.out.println(r);
	}

}
