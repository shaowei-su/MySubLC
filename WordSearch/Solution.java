public class Solution {

	public boolean helper(char[][] board, String word, int pos, int i, int j, int row, int col) {
		if (i < 0 || j < 0 || i >= row || j >= col) {
			return false;
		}

		if (board[i][j] == word.charAt(pos)) {
			char temp = board[i][j];
			board[i][j] = '#';
			if (pos == word.length() - 1) {
				return true;
			}
			if (helper(board, word, pos + 1, i + 1, j, row, col)
				|| helper(board, word, pos + 1, i - 1, j, row, col)
				|| helper(board, word, pos + 1, i, j + 1, row, col)
				|| helper(board, word, pos + 1, i, j - 1, row, col)) {
				return true;
			}
			board[i][j] = temp;
		}



		return false;  
	}

    public boolean exist(char[][] board, String word) {
        //edge cases
        if (board == null || board.length == 0 || board[0].length ==0) {
        	return false;
        }

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (helper(board, word, 0, i, j, row, col)) {
        			return true;
        		}
        	}
        }

        return false;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
    	String word = "see";
    	boolean r = sol.exist(board, word);
    	System.out.println(r);
    }
}