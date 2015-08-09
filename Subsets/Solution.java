import java.util.*;

public class Solution {
	public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int pos) {
		res.add(new ArrayList<Integer>(temp));
		for (int i = pos; i < nums.length; i++) {
			temp.add(nums[i]);
			helper(res, temp, nums, i + 1);
			temp.remove(temp.size() - 1);
		}

		return ;
	}


    public List<List<Integer>> subsets(int[] nums) {
        //edge cases
        if (nums == null) {
        	return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        helper(res, temp, nums, 0);

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = sol.subsets(nums);
        for (List l : res) {
            System.out.println(l);
        }
    }
}