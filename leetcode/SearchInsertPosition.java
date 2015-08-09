package leetcode;

public class SearchInsertPosition {

	
    public int searchInsert(int[] nums, int target) {
        //edge cases
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == target) {
    			return i;
    		} else if (nums[i] > target) {
    			return i;
    		} else {
    			continue;
    		}
    	}
    	
    	return nums.length;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition s = new SearchInsertPosition();
		int[] nums = {1, 3, 5, 6};
		int r = s.searchInsert(nums, 7);
		System.out.println(r);
	}

}
