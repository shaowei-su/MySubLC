//http://blog.csdn.net/yusiguyuan/article/details/45043031

public class Solution {
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
        int[][] mustSale = new int[N + 1][N + 1]; // mustSale[i][j] means prev-i days with j transactions, and sale on day-i
        int[][] mostProfit = new int[N + 1][N + 1]; // mostProfit[i][j] means prev-i days with j transaction, possibly no sale on day-i

        for (int i = 0; i <= k; i++) {
        	mustSale[0][i] = mostProfit[0][i] = 0;
        }

        for (int i = 1; i < N; i++) {
        	int gainOnThatDay = prices[i] - prices[i - 1];
        	mustSale[i][0] = 0;
        	for (int j = 1; j <= k; j++) {
        		mustSale[i][j] = Math.max(mostProfit[i - 1][j - 1] + Math.max(gainOnThatDay, 0), mustSale[i - 1][j] + gainOnThatDay);
        		mostProfit[i][j] = Math.max(mostProfit[i - 1][j], mustSale[i][j]);
        	}
        }

        return mostProfit[N - 1][k];
    }
}