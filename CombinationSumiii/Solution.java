import java.util.*;

public class Solution {

	public void combinationHelper(List<List<Integer>> res, List<Integer> temp, int k, int n, int pos) {
		if (temp.size() == k && n == 0) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = pos; i <= 9; i++) {
			if (i > n) {
				break;
			}
			temp.add(i);
			combinationHelper(res, temp, k, n - i, i + 1);
			temp.remove(temp.size() - 1);
		}

		return;
	}

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        combinationHelper(res, temp, k, n, 1);

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<List<Integer>> res = sol.combinationSum3(3, 9);
    	for (List<Integer> list: res) {
    		System.out.println(list);
    	}
    }
}