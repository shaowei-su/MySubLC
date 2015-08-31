/*
	Too stupid to figure this out:
	以任何节点为根所有bst的可能性等于左子树的可能乘以右子树的可能情况
*/

public class Solution {
    public int numTrees(int n) {
        if (n < 0) {
        	return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	dp[i] = 0;
        	for (int j = 0; j < i; j++) {
        		dp[i] += dp[j] * dp[i - j - 1];
        	}
        }

        return dp[n];
    }

    // public static void main(String[] args) {
    // 	Solution sol = new Solution();
    // 	System.out.println(sol.numTrees(4));
    // }
}