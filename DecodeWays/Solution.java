public class Solution {

	public boolean isValid(String s) {
		if (s.charAt(0) == '0') {
			return false;
		}
		int num = Integer.parseInt(s);
		return num >= 1 && num <= 26;
	}

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
        	return 0;
        }

        int[] dp = new int[s.length() + 1]; //dp[i] stands for how many solutions the prev-i has

        dp[0] = 1;
        if (isValid(s.substring(0, 1))) {
        	dp[1] = 1;
        } else {
        	dp[1] = 0;
        }

        for (int i = 2; i <= s.length(); i++) {
        	if (isValid(s.substring(i - 1, i))) {
        		dp[i] += dp[i - 1];
        	}
        	if (isValid(s.substring(i - 2, i))) {
        		dp[i] += dp[i - 2];
        	}
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.numDecodings("123"));
    }
}