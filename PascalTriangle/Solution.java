import java.util.*;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows < 1) {
        	return res;
        }
        for (int i = 1; i <= numRows; i++) {
        	List<Integer> temp = new ArrayList<Integer>();
        	temp.add(1);
        	for (int j = 1; j < i; j++) {
        		int left = res.get(i - 2).get(j - 1);
        		int right = j <= (i - 2) ? res.get(i - 2).get(j) : 0;
        		temp.add(left + right);   
        	}
        	res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<List<Integer>> res = sol.generate(5);
    	for (List<Integer> l : res) {
    		System.out.println(l);
    	}
    }
}