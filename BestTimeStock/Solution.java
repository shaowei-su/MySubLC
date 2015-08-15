public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
        	return 0;
        }

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
        	min = prices[i] < min ? prices[i] : min;
        	profit = (prices[i] - min) > profit ? (prices[i] - min) : profit;
        }

        return profit;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] prices = {1, 2, 3, 4, 2, 3, 6};
    	System.out.println(sol.maxProfit(prices));
    }
}