package leetcode;
/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 *The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 
 *Please note that your returned answers (both index1 and index2) are not zero-based.

 *You may assume that each input would have exactly one solution.
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
    	int[] res = new int[2];
    	for (int i = 0; i < nums.length; i++) {
    			for (int j = i + 1; j < nums.length; j++) {
    				if (nums[i] + nums[j] == target) {
    					res[0] = i + 1;
    					res[1] = j + 1;
    				}
    			}
    	}
    	return res;
        
    }
}
