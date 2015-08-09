package leetcode;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        //edge case
    	if (nums == null) return 0;
    	
    	int remIndex = -1;
    	int dupCount = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] == val && dupCount == 0) {
    			remIndex = i;
    			dupCount++;
    		} else if (nums[i] == val && dupCount > 0) {
    			dupCount++;
    		} else if (nums[i] != val && dupCount > 0) {
    			nums[remIndex] = nums[i];
    			remIndex++;
    		}
    	}
    	
    	return nums.length - dupCount;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveElement r = new RemoveElement();
		int[] nums = {0, 0, 1, 1, 2, 4, 3};
		int rest = r.removeElement(nums, 1);
		for (int i = 0; i < rest; i++) {
			System.out.println(nums[i]);
		}
	}

}
