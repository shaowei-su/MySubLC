package leetcode;

import java.util.*;
public class PermutationSequence {
	
	public int factorization(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorization(n - 1);
		}
	}

	public void helper(ArrayList<String> temp, boolean[] used, int n, StringBuilder sb, int k) {
		if (temp.size() >= k) {
			return;
		}
		
		if (n == sb.length()) {
			String newString = sb.toString();
			temp.add(newString);
		} else {
			for (int i = 1; i <= n; i++) {
				if (!used[i - 1]) {
					sb.append(i);
					used[i - 1] = true;
					helper(temp, used, n, sb, k);
					sb.deleteCharAt(sb.length() - 1);
					used[i - 1] = false;
				}
			}
		}
	}
	
    public String getPermutation(int n, int k) {
        //edge cases
    	if (k > factorization(n)) {
    		return "";
    	}
    	ArrayList<String> temp = new ArrayList<String>();
    	boolean[] used = new boolean[n];
    	StringBuilder sb = new StringBuilder();
    	helper(temp, used, n, sb, k);
    	
    	return temp.get(k - 1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence p = new PermutationSequence();
		String f = p.getPermutation(9, 219601);
		System.out.println(f);
	}

}
