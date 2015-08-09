package leetcode;

import java.util.*;
public class Permutations22 {
	
	public void rePermute(int[] nums, ArrayList<List<Integer>> res, boolean[] used, ArrayList<Integer> temp) {
		if (nums.length == temp.size()) {
			res.add(new ArrayList<Integer>(temp));
			return;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (i > 0 && used[i - 1] && nums[i] == nums[i - 1]) continue;
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
    	//sort
    	Arrays.sort(nums);
    	rePermute(nums, res, used, temp);
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations22 p = new Permutations22();
		int[] nums = {3, 3, 0, 0, 2, 3, 2};
		List<List<Integer>> r = p.permute(nums);
		for (List<Integer> l : r) {
			System.out.println(l);
		}
	}

}
