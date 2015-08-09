import java.util.*;


public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || wordDict == null || s == "" || wordDict.size() == 0) {
            return false;
        }

        //break[i] stands for that the previous i char can be separated 
        boolean[] breaker = new boolean[s.length() + 1];
        breaker[0] = true;
        int pos = 0;
        for (int i = 1; i <= s.length(); i++) {
        	breaker[i] = false;
        	for (int j = 0; j < i; j++) {
        		if (breaker[j] && wordDict.contains(s.substring(j, i))) {
        			breaker[i] = true;
        			break;
        		}
        	}
        }

        return breaker[s.length()];
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	Set<String> wordDict = new HashSet<String>();
    	wordDict.add("leet");
    	wordDict.add("code");
    	String s = "leetcode";
    	System.out.println(sol.wordBreak(s, wordDict));
    }
}