public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	//edge cases
    	if (obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) {
    		return 0;
    	}
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] steps = new int[m][n];
        for (int i = 0; i < m; i++) {
        	if (obstacleGrid[i][0] == 1) {
        		break;
        	} else {
        		steps[i][0] = 1;
        	}
        }

        for (int j = 0; j < n; j++) {
        	if (obstacleGrid[0][j] == 1) {
        		break;
        	} else {
        		steps[0][j] = 1;
        	}
        }

        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		if (obstacleGrid[i][j] == 1) {
        			steps[i][j] = 0;
        		} else {
        			steps[i][j] = steps[i - 1][j] + steps[i][j - 1];
        		}
        	}
        }

        return steps[m - 1][n - 1];
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int r = s.uniquePathsWithObstacles(o);
    }
}