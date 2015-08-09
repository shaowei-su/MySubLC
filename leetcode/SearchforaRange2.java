package leetcode;

public class SearchforaRange2 {
	
    public int[] searchRange(int[] nums, int target) {
    	if (nums == null || nums.length == 0) return null;
    	

    	int ll = 0;
    	int lr = nums.length - 1;
    	int mid = 0;
    	while (ll <= lr) {
    		mid = (ll + lr) / 2;
    		if (nums[mid] < target) {
    			ll = mid + 1;
    		} else {
    			lr = mid - 1;
    		}
    	}
    	
    	int rl = 0;
    	int rr = nums.length - 1;
    	while (rl <= rr) {
    		mid = (rl + rr) / 2;
    		if (nums[mid] <= target) {
    			rl = mid + 1;
    		} else {
    			rr = mid - 1;
    		}
    	}
    	
    	if (ll <= rr) {
    		int[] res = {ll, rr};
    		return res;
    	} else {
        	int[] res = {-1, -1};
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
