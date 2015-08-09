package leetcode;

import java.util.*;
public class CombinationSumII {
	
	public void combinator(int[] candidates, int target, ArrayList<List<Integer>> res, ArrayList<Integer> temp, int pos) {
		if (target == 0) {
			ArrayList<Integer> current = new ArrayList<Integer>(temp);
			res.add(current);
			return;
		}
		
		for (int i = pos; i < candidates.length; i++) {
			if (candidates[i] > target) {
				return;
			}
			
			temp.add(candidates[i]);

			combinator(candidates, target - candidates[i], res, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //edge cases
    	if (candidates == null || candidates.length == 0) {
    		return null;
    	}
    	
    	Arrays.sort(candidates);
    	ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	
    	combinator(candidates, target, res, temp, 0);
    	
    	HashSet<List<Integer>> dup = new HashSet<List<Integer>>(res);
    	res.clear();
    	res.addAll(dup);
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSumII c = new CombinationSumII();
		int [] candidates = {2, 3, 4, 7};
		
		List<List<Integer>> a = c.combinationSum2(candidates, 7);
		for (List<Integer> l: a) {
			System.out.println(l);
		}
	}

}
