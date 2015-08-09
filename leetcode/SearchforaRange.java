package leetcode;

public class SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        //edge cases
    	if (nums == null ||nums.length == 0) return null;
    	
    	int left = 0; 
    	int right = nums.length - 1;
    	int mid = 0;
    	boolean found = false;
    	
    	while (left <= right) {
    		mid = left + (right - left) / 2;
    		if (nums[mid] == target) {
    			found = true;
    			break;
    		} else if (nums[mid] < target) {
    			left = mid + 1;
    		} else {
    			right = mid - 1;
    		}
    	}
    	
    	if (!found) {
    		int[] res = {-1, -1};
    		return res;
    	} else {
    		left = mid;
    		right = mid;

    		while (left > 0) {
    			if (nums[left] == nums[left - 1]) {
    				left--;
    			} else {
    				break;
    			}
    		}


    		while (right < nums.length - 1) {
    			if (nums[right] == nums[right + 1]) {
    				right++;
    			} else {
    				break;
    			}
    		}
    		int[] res = {left, right};
    		return res;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchforaRange s = new SearchforaRange();
		int[] nums = {1};
		int[] r = s.searchRange(nums, 1);
		
		for (int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}
	}

}
