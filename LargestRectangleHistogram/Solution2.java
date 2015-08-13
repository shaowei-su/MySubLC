import java.util.*;

public class Solution2 {
    public int largestRectangleArea(int[] height) {
    	if (height == null || height.length == 0) {
    		return 0;
    	}

    	Stack<Integer> stack = new Stack<Integer>();
    	int max = 0;

    	for (int i = 0; i <= height.length; i++) {
    		int crt = (i == height.length) ? -1 : height[i];
    		while (!stack.isEmpty() && crt < height[stack.peek()]) {
    			int h = height[stack.pop()];
    			int w = stack.isEmpty() ? i : (i - stack.peek() - 1); // stack empty means that crt is the smallest
    			max = Math.max(max, h * w);
    		}
    		stack.push(i);
    	}

    	return max;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] height = {4, 2, 0, 3, 2, 5};
    	int r = sol.largestRectangleArea(height);
    	System.out.println(r);
    }
}