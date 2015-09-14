public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
        	return 0;
        }

        int row = dungeon.length;
        int col = dungeon[0].length;

        int[][] min = new int[row][col]; //min[x][y] means from(x, y) to dungeon[x][y] the minimum HP

        min[row - 1][col - 1] = Math.max(1 - dungeon[row - 1][col - 1], 1);

        for (int i = row - 2; i >= 0; i--) {
        	min[i][col - 1] = Math.max(min[i + 1][col - 1] - dungeon[i][col - 1], 1);
        }
        for (int i = col - 2; i >= 0; i--) {
        	min[row - 1][i] = Math.max(min[row - 1][i + 1] - dungeon[row - 1][i], 1);
        }

        for (int i = row - 2; i >= 0; i--) {
        	for (int j = col - 2; j >= 0; j--) {
        		int rightMin = Math.max(min[i][j + 1] - dungeon[i][j], 1);
        		int downMin = Math.max(min[i + 1][j] - dungeon[i][j], 1);
        		min[i][j] = Math.min(rightMin, downMin);
        	}
        }

        return min[0][0];
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[][] dungeon = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};
    	System.out.println(sol.calculateMinimumHP(dungeon));
    }
}