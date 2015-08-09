public class Solution2 {

    public int climbStairs(int n) {
        //edge cases
        if (n < 2) {
        	return n;
        }

        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n];
    }

    public static void main(String[] args) {
    	Solution2 s = new Solution2();
    	int r = s.climbStairs(5);
    	System.out.println(r);
    } 
}