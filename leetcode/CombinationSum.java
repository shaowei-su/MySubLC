package leetcode;

import java.util.*;
public class CombinationSum {

	public void combinator(int[] candidates, int target, ArrayList<List<Integer>> res, int pos, ArrayList<Integer> temp) {
		if (target == 0) {
			//cannot add temp directly !! its a object reference !!
			ArrayList<Integer> current = new ArrayList<Integer>(temp);
			res.add(current);
			return;
		}
		
		for (int i = pos; i < candidates.length; i++) {
			if (candidates[i] > target) {
				return;
			}
			
			temp.add(candidates[i]);
			combinator(candidates, target - candidates[i], res, i, temp);
			temp.remove(temp.size() - 1);
		}
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //edge cases
    	if (candidates == null || candidates.length == 0) {
    		return null;
    	}
    	
    	Arrays.sort(candidates);
    	ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	
    	combinator(candidates, target, res, 0, temp);
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum c = new CombinationSum();
		int [] candidates = {2, 3, 4, 7};
		List<List<Integer>> a = c.combinationSum(candidates, 7);
		for (List<Integer> l: a) {
			System.out.println(l);
		}
	}

}
