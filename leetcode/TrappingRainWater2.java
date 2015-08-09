package leetcode;

public class TrappingRainWater2 {

    public int trap(int[] height) {
    	//edge cases
    	if (height == null || height.length < 3) {
    		return 0;
    	}
    	
    	int l = 0;
    	int r = height.length - 1;
    	int min = 0;
    	int result = 0;
    	while (l < r) {
    		min = Math.min(height[l], height[r]);
    		
    		if (height[l] == min) {
    			l++;
    			while (l < r && height[l] < min) {
    				result += min - height[l];
    				l++;
    			}
    		} else {
    			r--;
    			while (l < r && height[r] < min) {
    				result += min - height[r];
    				r--;
    			}
    		}
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
