import java.util.*;

public class Solution {

	public String sortString(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return Arrays.toString(arr);
	}

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
        	return false;
        }
        if (s1.equals(s2)) {
        	return true;
        }

        //trim not useful recursion
        if (! sortString(s1).equals(sortString(s2))) {
        	return false;
        }
        int len = s1.length();

        for (int i = 1; i < len; i++) {
        	//case 1:
        	String s1l = s1.substring(0, i);
        	String s1r = s1.substring(i, len);
        	String s2l = s2.substring(0, i);
        	String s2r = s2.substring(i, len);
        	if (isScramble(s1l, s2l) && isScramble(s1r, s2r)) {
        		return true;
        	}

        	//case 2:
        	s2l = s2.substring(0, len - i);
        	s2r = s2.substring(len - i, len);
        	if (isScramble(s1l, s2r) && isScramble(s1r, s2l)) {
        		return true;
        	}
        }


        return false;

    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println("res = " + sol.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }
}