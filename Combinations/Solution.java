import java.util.*;

public class Solution {

	public void helper(List<List<Integer>> res, List<Integer> temp, int n, int k, int pos) {
		if (k == temp.size()) {
			res.add(new ArrayList<Integer>(temp));
		} else {
			for (int i = pos + 1; i <= n; i++) {
				temp.add(i);
				helper(res, temp, n, k, i);
				temp.remove(temp.size() - 1);
			}
		}

		return ;
	}

    public List<List<Integer>> combine(int n, int k) {
        if (n < 1) {
        	return null;
        }
        if (n < k) {
        	return null;
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        helper(res, temp, n, k, 0);

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<List<Integer>> res = sol.combine(5, 2);
    	for (List l: res) {
    		System.out.println(l);
    	}
    }
}