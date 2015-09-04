public class Solution {

	public void merge(char[][] grid, int i, int j, int row, int col) {
		if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '0';

		merge(grid, i + 1, j, row, col);
		merge(grid, i - 1, j, row, col);
		merge(grid, i, j - 1, row, col);
		merge(grid, i, j + 1, row, col);
	}

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
        	return 0;
        }
        int row = grid.length;
        int col = grid[0].length;

        int res = 0;

        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (grid[i][j] == '1') {
        			res++;
        			merge(grid, i, j, row, col);
        		}
        	}
        }

        return res;
    }
}