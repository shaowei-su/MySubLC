public class Solution {

	public int helper(int[][] grid, int m, int n, int i, int j) {
		if (i == m - 1 && j == n - 1) {
			return grid[i][j];
		}
		if (i < m - 1 && j < n - 1) {
			int pos1 = grid[i][j] + helper(grid, m, n, i + 1, j);
			int pos2 = grid[i][j] + helper(grid, m, n, i, j + 1);
			return Math.min(pos1, pos2);
		}
		if (i < m - 1) {
			return grid[i][j] + helper(grid, m, n, i + 1, j);
		}
		if (j < n - 1) {
			return grid[i][j] + helper(grid, m, n, i, j + 1);
		}

		return 0;
	}        
    
    public int minPathSum(int[][] grid) {
    	//edge cases
    	if (grid == null || grid.length == 0 || grid[0].length == 0) {
    		return 0;
    	}
    	int m = grid.length;
    	int n = grid[0].length;

    	return helper(grid, m, n, 0, 0);

    }

}
