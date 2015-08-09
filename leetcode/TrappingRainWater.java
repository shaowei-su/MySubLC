package leetcode;

public class TrappingRainWater {

    public int trap(int[] height) {
        //edge cases
    	if (height == null || height.length < 3) {
    		return 0;
    	}
    	
    	int[] left = new int[height.length];
    	int[] right = new int[height.length];
    	
    	int length = height.length;
    	left[0] = height[0];
    	right[length - 1] = height[length - 1];
    	int leftMax = height[0];
    	int rightMax = height[length - 1];
    	for (int i = 1; i < length; i++) {
    		//left to right
    		if (height[i] < leftMax) {
    			left[i] = leftMax;
    		} else {
    			left[i] = height[i];
    			leftMax = height[i];
    		}
    		//right to left
    		if (height[length - 1 - i] < rightMax) {
    			right[length - 1 - i] = rightMax;
    		} else {
    			right[length - 1 - i] = height[length - 1 - i];
    			rightMax = height[length - 1 - i];
    		}
    		
    	}
    	
    	int result = 0;
    	for (int i = 0; i < length; i++) {
    		result += Math.min(left[i], right[i]) - height[i];
    	}
    	
    	return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater t = new TrappingRainWater();
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int r = t.trap(height);
		System.out.println(r);
	}

}
