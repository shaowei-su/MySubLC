package leetcode;

public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        //edge cases
    	if (nums.length == 0) return -1;
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == target) {
    			return i;
    		} else if (i > 0 && nums[i] < nums[i - 1] && target > nums[i - 1]) {
    			return -1;
    		}
    	}
    	return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int r = s.search(nums, 0);
		System.out.println(r);
	}

}
