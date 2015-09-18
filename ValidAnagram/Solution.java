import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
        	return false;
        }
        if (s.length() == 0) {
        	return true;
        }
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        Arrays.sort(arrT);
        Arrays.sort(arrS);

        return String.valueOf(arrT).equals(String.valueOf(arrS));
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.isAnagram("eat", "tea"));
    }
}