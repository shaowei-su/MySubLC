public class Solution {
    public int minDistance(String word1, String word2) {
        int leng1 = word1.length();
        int leng2 = word2.length();
        int[][] dp = new int[leng1 + 1][leng2 + 1];
        //init

        for (int i = 0; i <= leng1; i++) {
        	dp[i][0] = i;
        }
        for (int j = 0; j <= leng2; j++) {
        	dp[0][j] = j;
        }

        for (int i = 0; i < leng1; i++) {
        	char c1 = word1.charAt(i);
        	for (int j = 0; j < leng2; j++) {
        		char c2 = word2.charAt(j);
        		if (c1 == c2) {
        			dp[i + 1][j + 1] = dp[i][j];
        		} else {
        			int insert = dp[i][j + 1] + 1;
        			int delete = dp[i + 1][j] + 1;
        			int replace = dp[i][j] + 1;
        			int min = insert < delete ? insert : delete;
        			min = min < replace ? min : replace;
        			dp[i + 1][j + 1] = min;
        		}
        	}
        }

        return dp[leng1][leng2];
    }

}