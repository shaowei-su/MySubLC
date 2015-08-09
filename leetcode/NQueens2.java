package leetcode;

import java.util.*;
public class NQueens2 {

	public boolean check(int[] record, int row) {
		for (int i = 0; i < row; i++) {
			if (record[i] == record[row] || Math.abs(record[i] - record[row]) == row - i) {
				return false;
			}
		}
		return true;
	}
	
	public void helper(int n, int row, List<List<String>> res, int[] record) {
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
			return;
		} else {
			for (int i = 0; i < n; i++) {
				record[row] = i;
				if (check(record, row)) {
					helper(n, row + 1, res, record);
				}
			}
		}
	}
    public int totalNQueens(int n) {
        //edge cass
    	if (n == 0) return 0;
    	
    	List<List<String>> res = new ArrayList<List<String>>();
    	int[] record = new int[n];
    	helper(n, 0, res, record);
    	return res.size();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens2 n = new NQueens2();
		int r = n.totalNQueens(4);
		System.out.println(r);
	}

}
