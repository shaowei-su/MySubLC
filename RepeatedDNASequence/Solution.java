import java.util.*;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> list = new ArrayList<String>();
        if (s == null || s.length() == 0) {
        	return list;
        }
        for (int i = 0; i < s.length() - 9; i++) {
        	String sub = s.substring(i, i + 10);
        	for (int j = i + 10; j < s.length() - 9; j++) {
        		if (sub.equals(s.substring(j, j + 10))) {
        			list.add(sub);
        			break;
        		}
        	}
        }

        return list;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<String> res = sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    	for (String s: res) {
    		System.out.println(s);
    	}
    }
}