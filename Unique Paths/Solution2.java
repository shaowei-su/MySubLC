import java.util.*;

public class Solution2 {

    public int uniquePaths(int m, int n) {
    	//edge cases
    	if (m <= 0 || n <= 0) {
    		return 0;
    	}

    	int[][] steps = new int[m][n];
    	for (int i = 0; i < m; i++) {
    		steps[i][0] = 1;
    	}
    	for (int j = 0; j < n; j++) {
    		steps[0][j] = 1;
    	}

    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			steps[i][j] = steps[i - 1][j] + steps[i][j - 1];
    		}
    	}

    	return steps[m - 1][n - 1];
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int r = sol.uniquePaths(23, 12);
    	System.out.println(r);
    }
}