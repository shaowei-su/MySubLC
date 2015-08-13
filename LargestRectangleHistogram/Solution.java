import java.util.*;

public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
        	return 0;
        }

        int largest = 0;

        for (int i = 0; i < height.length; i++) {
        	int left = (i > 0) ? i - 1 : 0;
        	int right = (i < height.length - 1) ? i + 1 : height.length - 1;
        	while (left >= 0) {
        		if (height[left] < height[i]) {
        			break;
        		}
        		left--;
        	}
        	while (right <= height.length - 1) {
        		if (height[right] < height[i]) {
        			break;
        		}
        		right++;
        	}

        	int crtLargest = (right - left - 1) * height[i];
        	largest = Math.max(largest, crtLargest);
        }

        return largest;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] height = {2, 1, 5, 6, 2,};
    	int r = sol.largestRectangleArea(height);
    	System.out.println(r);
    }
}