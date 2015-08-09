package leetcode;

import java.util.*;
public class Permutations {
	
	public void rePermute(int[] nums, ArrayList<List<Integer>> res, boolean[] used, ArrayList<Integer> temp) {
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

    public List<List<Integer>> permute(int[] nums) {
        //edge cases
    	if (nums == null || nums.length == 0) {
    		return null;
    	}
    	
    	ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	boolean[] used = new boolean[nums.length];
    	rePermute(nums, res, used, temp);
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations p = new Permutations();
		int[] nums = {1, 2, 1};
		List<List<Integer>> r = p.permute(nums);
		for (List<Integer> l : r) {
			System.out.println(l);
		}
	}

}
