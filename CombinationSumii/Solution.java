import java.util.*;

public class Solution {

	public void combinationHelper(int[] candidates, List<List<Integer>> res, List<Integer> temp, int target, int pos) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = pos; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}
			if (i != pos && candidates[i] == candidates[i - 1]) {
				continue;
			}
			temp.add(candidates[i]);
			combinationHelper(candidates, res, temp, target - candidates[i], i + 1);
			temp.remove(temp.size() - 1);
		}
		return;
	}

	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	 	if (candidates == null || candidates.length == 0) {
	 		return null;
	 	}
	 	Arrays.sort(candidates);
	 	List<List<Integer>> res = new ArrayList<List<Integer>>();
	 	List<Integer> temp = new ArrayList<Integer>();

	 	combinationHelper(candidates, res, temp, target, 0);

	 	return res;
	 }

	 public static void main(String[] args) {
	 	Solution sol = new Solution();
	 	int[] candidates = {10, 1, 2, 7, 6, 1, 5};
	 	List<List<Integer>> res = sol.combinationSum2(candidates, 8);
	 	for (List<Integer> list: res) {
	 		System.out.println(list);
	 	}
	 }
}