public class Solution2 {
    public int maxProfit(int[] prices) {
 		if (prices == null || prices.length == 0) {
 			return 0;
 		}

 		int local = 0;
 		int global = 0;

 		for (int i = 0; i < prices.length - 1; i++) {
 			local = Math.max(prices[i + 1] - prices[i] + local, 0);//if less than 0, there must be lower price to buy in
 			global = Math.max(local, global);
 		}

 		return global;

 	}

 	public static void main(String[] args) {
 		Solution2 sol = new Solution2();
 		int[] prices = {2, 3, 6, 2, 1, 8};
 		System.out.println(sol.maxProfit(prices));
 	}

}