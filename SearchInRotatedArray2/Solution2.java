public class Solution {
    public boolean search(int[] nums, int target) {
    	if (nums == null || nums.length == 0) {
    		return false;
    	}

    	int start = 0;
    	int end = nums.length - 1;

    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (nums[mid] == target) {
    			return true;
    		}

    		if (nums[mid] > nums[start]) {
    			if (target >= nums[start] && target < nums[mid]) {
    				end = mid;
    			} else {
    				start = mid;
    			}
    		} else if (nums[mid] < nums[start]) {
    			if (target <= nums[end] && target > nums[mid]) {
    				start = mid;
    			} else {
    				end = mid;
    			}
    		} else {
    			start++;
    		}
    	}

    	if (nums[start] == target) {
    		return true;
    	}
    	if (nums[end] == target) {
    		return true;
    	}

    	return false;
    }
}