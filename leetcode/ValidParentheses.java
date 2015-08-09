package leetcode;

import java.util.*;
public class ValidParentheses {

    public boolean isValid(String s) {
        //edge
    	if (s.length() == 0 || s == null) {
    		return false;
    	}
    	
    	Stack<Character> stack = new Stack<Character>();
    	
    	HashMap<Character, Character> map = new HashMap<Character, Character>();
    	map.put('{', '}');
    	map.put('(', ')');
    	map.put('[', ']');
    	
    	for (int i = 0; i < s.length(); i++) {
    		char current = s.charAt(i);
    		if (map.keySet().contains(current)) {
    			stack.push(current);
    		} else if (map.values().contains(current)) {
    			if (!stack.isEmpty() && map.get(stack.peek()) == current) {
    				stack.pop();
    			} else {
    				return false;
    			}
    		} 
    	}
    	
    	return stack.empty();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParentheses v = new ValidParentheses();
		String s = "{}";
		boolean r = v.isValid(s);
		System.out.println("result " + r);

	}

}
