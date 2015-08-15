public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
        	return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
        	if (i + 1 < prices.length && prices[i + 1] > prices[i]) {
        		max += prices[i + 1] - prices[i];
        	}
        }

        return max;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] prices = {1, 2, 3, 4, 5, 6};
    	System.out.println(sol.maxProfit(prices));
    }
}