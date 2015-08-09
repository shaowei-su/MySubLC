package leetcode;

public class ContainerWithMostWater {
	
    public int maxArea(int[] height) {
        int length = height.length;
        if (length < 2) {
        	return 0;
        }
        int left = 0;
        int right = length -1;
        int max = 0;
        while (left < right) {
        	max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
        	if (height[left] < height[right]) {
        		left++;
        	} else {
        		right--;
        	}
        }
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
