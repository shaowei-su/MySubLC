//BFS

public class Solution {

    public Queue<Integer> queue = new LinkedList<Integer>();

    public void enqueue(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O') {
            return;
        }
        queue.offer(i * col + j);
        board[i][j] = '#';
    }

    public void merge(char[][] board, int i, int j, int row, int col) {

        enqueue(board, i, j, row, col);

        while (!queue.isEmpty()) {
            int crt = queue.poll();
            int r = crt / col;
            int c = crt % col;

            enqueue(board, r + 1, c, row, col);
            enqueue(board, r - 1, c, row, col);
            enqueue(board, r, c + 1, row, col);
            enqueue(board, r, c - 1, row, col);

        }

        return;
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



        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
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