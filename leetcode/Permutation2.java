package leetcode;

import java.util.*;

public class Permutation2 {

	public void rePermute(int[] nums, Set<List<Integer>> res, boolean[] used, ArrayList<Integer> temp) {
		if (nums.length == temp.size()) {
			res.add(new ArrayList<Integer>(temp));
			return;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!used[i]) {
					used[i] = true;
					temp.add(nums[i]);
					rePermute(nums, res, used, temp);
					temp.remove(temp.size() - 1);
					used[i] = false;
				}
			}
		}
	}
	
    public List<List<Integer>> permuteUnique(int[] nums) {
        //edge cases
    	if (nums == null || nums.length == 0) {
    		return null;
    	}
    	
    	Set<List<Integer>> res = new HashSet<List<Integer>>();
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	boolean[] used = new boolean[nums.length];
    	rePermute(nums, res, used, temp);
    	
    	return new ArrayList<List<Integer>>(res);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation2 p = new Permutation2();
		int[] nums = {3, 3, 0, 0, 2, 3, 2};
		List<List<Integer>> r = p.permuteUnique(nums);
		for (List<Integer> l : r) {
			System.out.println(l);
		}
	}

}
