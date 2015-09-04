//DFS

public class Solution {

    public void merge(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        merge(board, i + 1, j, row, col);
        merge(board, i - 1, j, row, col);
        merge(board, i, j + 1, row, col);
        merge(board, i, j - 1, row, col);
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
        	return;
        }

        int row = board.length;
        int col = board[0].length;

        if (row <= 2 || col <= 2) {
        	return;
        }

        //merge the edge inside, from left/right
        for (int i = 0; i < row; i++) {
            merge(board, i, 0, row, col);
            merge(board, i, col - 1, row, col);
        }
        //merge from top/bottom
        for (int i = 0; i < col; i++) {
            merge(board, 0, i, row, col);
            merge(board, row - 1, i, row, col);
        }



        for (int i = 1; i < row - 1; i++) {
        	for (int j = 1; j < col - 1; j++) {
        		if (board[i][j] == '#') {
        			board[i][j] = 'O';
        		} else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
        	}
        }

        return;
    }
}