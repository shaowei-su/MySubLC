package leetcode;

import java.util.*;

public class LongestSubstring2 {

    public int lengthOfLongestSubstring(String s) {
    	char[] arr = s.toCharArray();
    	int result = 0;
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (! map.containsKey(arr[i])) {
    			map.put(arr[i], i);
    		} else {
    			result = Math.max(result, map.size());
    			i = map.get(arr[i]);
    			map.clear();
    		}
    	}
    	
    	return result;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "eeeee";
		LongestSubstring l = new LongestSubstring();
		int length = l.lengthOfLongestSubstring(test);
		System.out.println("test = " + length);
	}

}
