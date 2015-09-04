import java.util.*;

public class Solution {

	public void helper(String s, Set<String> wordDict, String str, List<String> res, int pos) {
		if (pos == s.length()) {
			res.add(str);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int j = pos; j < s.length(); j++) {
			sb.append(s.charAt(j));
			if (wordDict.contains(sb.toString())) {
				String newItem = str.length() > 0 ? (str + " " + sb.toString()) : (sb.toString());
				helper(s, wordDict, newItem, res, j + 1);				
			}
		}

		return ;
	}

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
        	return res;
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
        	dp[i] = false;
        	for (int j = 0; j < i; j++) {
        		if (dp[j] && wordDict.contains(s.substring(j, i))) {
        			dp[i] = true;
        		}
        	}
        }
        if (dp[s.length()]) {
	        helper(s, wordDict, "", res, 0);        	
        }

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	Set<String> wordDict = new HashSet<String>();
    	wordDict.add("cat");
    	wordDict.add("cats");
    	wordDict.add("and");
    	wordDict.add("sand");
    	wordDict.add("dog");
    	List<String> res = sol.wordBreak("catsanddog", wordDict);
    	for (String s: res) {
    		System.out.println(s);
    	}
    }
}