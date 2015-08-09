import java.util.*;

public class Solution {

	public int dfs(int i, int j, int m, int n) {
		if (i == m - 1 && j == n - 1) {
			return 1;
		} else if (i < m - 1 && j < n - 1) {
			return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
		} else if (i < m - 1) {
			return dfs(i + 1, j, m, n);
		} else if (j < n - 1) {
			return dfs(i, j + 1, m, n);
		}

		return 0;
	}

    public int uniquePaths(int m, int n) {
    	return dfs(0, 0, m, n);
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int r = sol.uniquePaths(23, 12);
    	System.out.println(r);
    }
}