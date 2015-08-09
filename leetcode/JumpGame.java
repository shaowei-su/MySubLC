package leetcode;

public class JumpGame {

    public boolean canJump(int[] nums) {
        //edge cases
    	if (nums.length < 2) {
    		return true;
    	} 
    	
    	int max = nums[0];
    	for (int i = 0; i < nums.length; i++) {
    		//success
    		if (max >= nums.length - 1) {
    			return true;
    		}
    		//fail
    		if (nums[i] == 0 && max <= i) {
    			return false;
    		}
    		//update
    		if (max < nums[i] + i) {
    			max = nums[i] + i;
    		}
    	}
    	
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame j = new JumpGame();
		int[] nums = {2, 3, 1, 1, 4};
		boolean r = j.canJump(nums);
		System.out.println(r);
	}

}
