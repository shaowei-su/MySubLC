import java.util.*;

public class Solution {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
        	return 0;
        }
        String operator = "+-*/";
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < tokens.length; i++) {
        	if (!operator.contains(tokens[i])) {
        		stack.push(tokens[i]);
        	} else {
        		int a = Integer.parseInt(stack.pop());
        		int b = Integer.parseInt(stack.pop());

        		switch(tokens[i]) {
        			case "+":
        				stack.push(String.valueOf(b + a));
        				break;
        			case "-":
        				stack.push(String.valueOf(b - a));
        				break;
        			case "*":
        				stack.push(String.valueOf(b * a));
        				break;
        			case "/":
        				stack.push(String.valueOf(b / a));
        				break;
        			default:
        				break;
        		}
        	}
        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String[] tokens = {"4", "13", "5", "/", "+"};
    	System.out.println(sol.evalRPN(tokens));
    }
}