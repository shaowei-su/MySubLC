public class Solution {

	public int dfs(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return dfs(0);
		}

		return dfs(n - 1) + dfs(n - 2);


	}
    public int climbStairs(int n) {
        //edge cases
        if (n < 2) {
        	return n;
        }

        return dfs(n);
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int r = s.climbStairs(5);
    	System.out.println(r);
    } 
}