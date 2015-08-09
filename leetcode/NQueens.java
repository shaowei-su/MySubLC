package leetcode;

import java.util.*;

public class NQueens {

	public void helper(int n, int row, int[] record, List<List<String>> res) {
		if (n == row) {
			List<String> temp = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (record[i] != j) {
						sb.append('.');
					} else {
						sb.append('Q');
					}
				}
				temp.add(sb.toString());
			}
			res.add(temp);
		} else {
			for (int i = 0; i < n; i++) {
				record[row] = i;
				if (check(record, row)) {
					helper(n, row + 1, record, res);
				}
			}
		}
	}
	
	public boolean check(int[] record, int row) {
		for (int i = 0; i < row; i++) {
			if (record[i] == record[row] || Math.abs(record[i] - record[row]) == (row - i)) {
				return false;
			}
		}
		return true;
	}
	
    public List<List<String>> solveNQueens(int n) {
        //edge cases
    	if (n == 0) return null;
    	
    	List<List<String>> res = new ArrayList<List<String>>();
    	int[] record = new int[n];
    	helper(n, 0, record, res);
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens n = new NQueens();
		List<List<String>> r = n.solveNQueens(4);
		for (List<String> l: r) {
			for(String t: l) {
				System.out.println(t);
			}
		}
	}

}
