package leetcode;

import java.util.*;
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        //edge case
    	if (s == null || s.length() < 2) return 0;
    	int max = 0;
    	Stack<int[]> stack = new Stack<int[]>();
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '(') {
    			int[] temp = {i, 0};
    			stack.push(temp);
    		} else {
    			if (stack.empty() || stack.peek()[1] == 1) {
    				int[] temp = {i, 1};
    				stack.push(temp);
    			} else {
    				stack.pop();
    				int currentMax = 0;
    				if (stack.empty()) {
    					currentMax = i + 1;
    				} else {
    					currentMax = i - stack.peek()[0];
    				}
    				max = Math.max(currentMax, max);
    			}
    		}
    	}
    	
    	return max;
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParentheses l = new LongestValidParentheses();
		int r = l.longestValidParentheses("()");
		System.out.println(r);
	}

}
