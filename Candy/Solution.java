public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
        	return 0;
        }
        int res = 0;
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
        	if (ratings[i] > ratings[i - 1]) {
        		candies[i] = candies[i - 1] + 1;
        	} else {
        		candies[i] = 1;
        	}
        }

        res = candies[candies.length - 1];
        for (int i = candies.length - 2; i >= 0; i--) {
        	int crt = 1;
        	if (ratings[i] > ratings[i + 1]) {
        		crt = candies[i + 1] + 1;
        	}

        	res += Math.max(crt, candies[i]);
        	candies[i] = crt;
        }

        return res;
    }
}