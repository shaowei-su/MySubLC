package leetcode;

public class RemoveDuplicatesfromSortedArray {

	
    public int removeDuplicates(int[] nums) {
        //edge cases
    	if (nums.length < 2) return nums.length;
    	
    	int cur = nums[0];
    	int dup = -1;
    	int totCount = 0;
    	
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] == cur && totCount == 0) {
    			dup = i;
    			totCount++;
    		} else if (nums[i] == cur && totCount > 0) {
    			totCount++;
    		} else if (nums[i] != cur && totCount > 0) {
    			nums[dup] = nums[i];
    			cur = nums[i];
    			dup++;
    		} else if (nums[i] != cur && totCount == 0) {
    			cur = nums[i];
    		}
    	}
    	
    	return nums.length - totCount;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
		int[] test = {1, 1, 1, 2};
		int hi = r.removeDuplicates(test);
		System.out.println(hi);
		for (int i = 0; i < hi; i++) {
			System.out.println(test[i]);
		}
		
	}

}
