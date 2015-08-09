package leetcode;
/*
 * Given a string, find the length of the longest substring without repeating characters. For example,
 *  the longest substring without repeating letters for "abcabcbb" is "abc",
 *   which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int start = 0;
        boolean[] flags = new boolean[256];
        char[] arr = s.toCharArray(); //how to transfer string to char array
        
        for(int i = 0; i < arr.length; i++) {
        	char current = arr[i];
        	if (flags[current]) {
        		result = Math.max(result, i - start);
        		for (int k = start; k < i; k++) {
        			if (arr[k] == current ) {
        				start = k + 1;
        				break;
        			}
        			flags[arr[k]] = false;
        		}
        	} else {
        		flags[current] = true;
        	}
        }
        
        result = Math.max(result, arr.length - start);
        
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
