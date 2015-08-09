import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
        //edge cases
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
        	return "";
        }

        //save target
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
        	if (target.containsKey(t.charAt(i))) {
        		target.put(t.charAt(i), target.get(t.charAt(i)) + 1);
        	} else {
        		target.put(t.charAt(i), 1);
        	}
        }

        int count = 0;
        int left = 0;
        String window = "";
        int minLength = s.length() + 1; //ensure there is a window!! even the worst case
        //save source
        HashMap<Character, Integer> source = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
        	char cur = s.charAt(i);
        	//maintain the source map
        	if (target.containsKey(cur)) {
        		if (source.containsKey(cur)) {
        			if (source.get(cur) < target.get(cur)) {
	        			source.put(cur, source.get(cur) + 1);
	        			count++;	
        			} else {
        				source.put(cur, source.get(cur) + 1);
        			}

        		} else {
        			source.put(cur, 1);
        			count++;
        		}
        	}

        	if (t.length() == count) {
        		char theLeftChar = s.charAt(left);
        		while (!target.containsKey(theLeftChar) || target.get(theLeftChar) < source.get(theLeftChar)) {
        			if (target.containsKey(theLeftChar) && target.get(theLeftChar) < source.get(theLeftChar)) {
        				source.put(theLeftChar, source.get(theLeftChar) - 1);
        			}
        			left++;
        			theLeftChar = s.charAt(left);
        		}

        		if (i - left + 1 < minLength) {
        			window = s.substring(left, i + 1);
        			minLength = i - left + 1;
        		}
        	}
        }

        return window;
        //ps: substring is not capital "S"
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String s = "ADOBECODEBANC";
    	String t = "ABC";
    	String r = sol.minWindow(s, t);
    	System.out.println(r);
    }
}