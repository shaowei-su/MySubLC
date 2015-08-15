public class Solution {
    public int trailingZeroes(int n) {
        if (n < 0) {
        	return 0;
        }

        int counter = 0;

        while (n > 0) {
        	counter += n / 5;
        	n = n / 5;
        }
        return counter;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.trailingZeroes(15));
    }
}