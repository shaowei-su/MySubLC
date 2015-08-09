package leetcode;

public class SudokuSolver {
	
	public boolean isValid(char[][] board, int row, int col, char test) {
		int xPos = row / 3;
		int yPos = col / 3;
		
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == test) return false;
			if (board[i][col] == test) return false;
			if (board[i / 3 + xPos * 3][i % 3 + yPos * 3] == test) return false;
		}
		
		return true;
	}
	
	public boolean solver(char[][] board, int row, int col) {
		if (row < 9 && col < 9) {
			if (board[row][col] != '.') {
				if (col < 8) {
					return solver(board, row, col + 1);
				} else if (row < 8) {
					return solver(board, row + 1, 0);
				} else {
					return true;
				}
			} else {
				for (int k = 1; k <= 9; k++) {
					char temp = (char)('0' + k);
					if (isValid(board, row, col, temp)) {
						board[row][col] = temp;
						if (solver(board, row, col)) {
							return true;
						} else {
							board[row][col] = '.';
						}
					}
				}
			}
			return false;
		}
    	return true;
	}
	
    public void solveSudoku(char[][] board) {
    	solver(board, 0, 0);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SudokuSolver s = new SudokuSolver();
		char[][] board = {{'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
		s.solveSudoku(board);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
