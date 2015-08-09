package leetcode;

public class JumpGameII {

    public int jump(int[] nums) {
        //edge cases
    	if (nums == null || nums.length < 2) {
    		return 0;
    	}
    	
    	int step = 0;
    	int reach = 0; 
    	int lastReach = 0;
    	
    	for (int i = 0; i < nums.length && i <= reach; i++) {
    		if (i > lastReach) {
    			step++;
    			lastReach = reach;
    		}
    		
    		//reach equal to the maximum place we can get to right now
    		reach = Math.max(reach, i + nums[i]);
    	}
    	
    	if (reach < nums.length - 1) {
    		return 0;
    	}
    	
    	return step;
    	
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGameII j = new JumpGameII();
		int[] nums = {2, 3, 1, 1, 4};
		int r = j.jump(nums);
		System.out.println(r);
	}

}
