public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
        	return -1;
        }

        //dp[i][j] stands for the number of subsequences from first i in s and first j in t matches
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
        	dp[i][0] = 1;
        }
        for (int i = 1; i < t.length(); i++) {
        	dp[0][i] = 0;
        }

        for (int i = 1; i <= s.length(); i++) {
        	for (int j = 1; j <= t.length(); j++) {
        		dp[i][j] = dp[i - 1][j];
        		if (s.charAt(i - 1) == t.charAt(j - 1)) {
        			dp[i][j] += dp[i - 1][j - 1];
        		}
        	}
        }

        return dp[s.length()][t.length()];  
    }
}