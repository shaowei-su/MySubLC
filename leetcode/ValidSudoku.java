package leetcode;

import java.util.*;

public class ValidSudoku {
	
	public boolean rowValid(char[][] board, int row) {
		ArrayList<Character> temp = new ArrayList<Character>();
		for (int i = 0; i < 9; i++) {
			if (board[row][i] != '.') {
				if (temp.contains(board[row][i])) {
					return false;
				} else {
					temp.add(board[row][i]);
				}
			}
		}
		return true;
	}

	public boolean columnValid(char[][] board, int col) {
		ArrayList<Character> temp = new ArrayList<Character>();
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != '.') {
				if (temp.contains(board[i][col])) {
					return false;
					
				} else {
					temp.add(board[i][col]);
				}
			}
		}
		return true;
	}

	public boolean squarValid(char[][] board, int pos) {
		int row = pos / 3;
		int col = pos % 3;
		ArrayList<Character> temp = new ArrayList<Character>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i + row * 3][j + col * 3] != '.') {
					if (temp.contains(board[i + row * 3][j + col * 3])) {
						return false;
						
					} else {
						temp.add(board[i + row * 3][j + col * 3]);
					}
				}
			}
		}
		return true;
	}

	
    public boolean isValidSudoku(char[][] board) {
    	//edge cases
    	if (board == null || board.length != 9)
    		return false;
    	for (int i = 0; i < board.length; i++) {
    		if (board[i].length != 9) {
    			return false;
    		}
    	}
    	
    	for (int i = 0; i < 9; i++) {
    		if (!rowValid(board, i)) {
    			return false;
    		}
    		if (!columnValid(board, i)) {
    			return false;
    		}
    		if (!squarValid(board, i)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] te = {{'.', '8', '7', '6', '5', '4', '3', '2', '1'}, {'2', '.', '.', '.', '.', '.', '.', '.', '.'}, {'3', '.', '.', '.', '.', '.', '.', '.', '.'}, {'4', '.', '.', '.', '.', '.', '.', '.', '.'}, {'5', '.', '.', '.', '.', '.', '.', '.', '.'}, {'6', '.', '.', '.', '.', '.', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
		ValidSudoku v = new ValidSudoku();
		boolean r = v.isValidSudoku(te);
		System.out.println(r);
	}

}
