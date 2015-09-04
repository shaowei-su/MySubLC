import java.util.*;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> res = new ArrayList<Integer>();
        if (rowIndex < 0) {
        	return res;
        }
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
        	for (int j = res.size() - 2; j >= 0; j--) {
        		res.set(j + 1, res.get(j) + res.get(j + 1));
        	}
        	res.add(1);
        }

        return res;
    }

    public static  void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.getRow(3));
    }
}