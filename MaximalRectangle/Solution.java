import java.util.*;

public class Solution {

	public int maxHelper(char[][] matrix, int i, int j) {
		int maxLength = 0;
		int maxHeight = 0;
		int res = 0;
		int colNum = j;
		while (matrix[i][colNum] == '1') {
			maxLength++;
			if (colNum + 1 >= matrix[0].length) {
				break;
			} else {
				colNum++;
			}
		}
		//System.out.println("len = " + maxLength + " col = " + maxHeight);
		int rowNum = i;
		while (matrix[rowNum][j] == '1') {
			
			res = Math.max(res, maxHeight * maxLength);
			maxHeight++;
			for (int pos = j; pos < j + maxLength; pos++) {
				if (matrix[rowNum][pos] != '1') {
					maxLength = pos - j;
					break;
				}
			}
			if (rowNum + 1 >= matrix.length) {
				break;
			} else {
				rowNum++;
			}
		}
		//System.out.println("len = " + maxLength + " col = " + maxHeight);
		return Math.max(res, maxHeight * maxLength);
	}

    public int maximalRectangle(char[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return 0;
    	}
    	int row = matrix.length;
    	int col = matrix[0].length;

    	int max = 0;
    	for (int i = 0; i < row; i++) {
    		for (int j = 0; j < col; j++) {
    			//System.out.println("i = " + i + " j = " + j);
    			max = Math.max(max, maxHelper(matrix, i, j));
    		}
    	}

    	return max;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
    	System.out.println(sol.maximalRectangle(matrix));
    }
}