public class Solution2 {
    public int maxProfit(int k, int[] prices) {
        if (k < 0 || prices == null || prices.length == 0) {
        	return 0;
        }

        //if k is larger, it becomes to infinite buying
        if (k > prices.length / 2) {
        	int profit = 0;
        	for (int i = 1; i < prices.length; i++) {
        		if (prices[i] > prices[i - 1]) {
        			profit += prices[i] - prices[i - 1];
        		}
        	}

        	return profit;
        }
        int N = prices.length;
        int[][] subProfit = new int[N][N];

        for (int i = 0; i < N - 1; i++) {
        	for (int j = i + 1; j < N; j++) {
        		subProfit[i][j] = prices[j] - prices[i];
        	}
        }

        int[][] max = new int[N + 1][k + 1]; //max[i][j] means prev-i day have j transactions

        // for (int i = 0; i <= N; i++) {
        // 	max[i][0] = 0;
        // }

        // for (int i = 0; i <= k; i++) {
        // 	max[0][i] = Integer.MIN_VALUE;
        // }

        for (int j = 1; j <= k; j++) {
        	for (int i = 1; i <= N; i++) {
        		for (int x = 0; x + 1 < i; x++) {
        			//System.out.println("j = " + j + " i = " + i + " x = " + x + " sub = " + subProfit[x][i - 1]);
        			max[i][j] = Math.max(max[x][j - 1] + subProfit[x][i - 1], max[i][j]);
        		}
        	}
        }

        return max[N][k];
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[] prices = {1, 2};
    	System.out.println(sol.maxProfit(1, prices));
    }



}