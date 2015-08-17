//这题就是largest rectangle in histogram 
//想想从不同的行把矩阵切开，然后从下往上看

import java.util.*;

public class Solution2 {
    public int maximalRectangle(char[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return 0;
    	}
    	int row = matrix.length;
    	int col = matrix[0].length;

    	int[][] board = new int[row][col];
    	for (int i = 0; i < row; i++) {
    		for (int j = 0; j < col; j++) {
    			if (i == 0) {
    				board[i][j] = (matrix[i][j] == '1') ? 1 : 0;
    			} else {
    				board[i][j] = (matrix[i][j] == '1') ? board[i - 1][j] + 1 : 0; //calculate the height of the histogram
    			}
    		}
    	}
    	int res = 0;
    	for (int i = 0; i < row; i++) {
    		Stack<Integer> stack = new Stack<Integer>();
    		for (int j = 0; j < col; j++) {
    			while (!stack.isEmpty() && board[i][j] < board[i][stack.peek()]) {
    				int val = stack.peek();
    				stack.pop();
    				int area = board[i][val] * (stack.isEmpty() ? j : j - stack.peek() - 1);
    				res = Math.max(res, area);
    			}
    			stack.push(j);
    		}
    		while (!stack.isEmpty()) {
    			int val = stack.pop();
    			int area = board[i][val] * (stack.isEmpty() ? col : col - stack.peek() - 1);
    			res = Math.max(res, area);
    		}
    	}

    	return res;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
    	System.out.println(sol.maximalRectangle(matrix));
    }
}