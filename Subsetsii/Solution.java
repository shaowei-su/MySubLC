import java.util.*;

public class Solution {

	public void subsetHelper(List<List<Integer>> res, List<Integer> temp, int[] nums, int pos) {
		res.add(new ArrayList<Integer>(temp));

		for (int i = pos; i < nums.length; i++) {
			if (i != pos && nums[i] == nums[i - 1]) {
				continue;
			} else {
				temp.add(nums[i]);
				subsetHelper(res, temp, nums, i + 1);
				temp.remove(temp.size() - 1);
			}
		}

		return;
	}

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //edge
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
        	return res;
        }
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        subsetHelper(res, temp, nums, 0);

        return res;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[] nums = {1, 2, 2};
    	List<List<Integer>> res = sol.subsetsWithDup(nums);
    	for (List<Integer> list: res) {
    		System.out.println(list);
    	}
    }
}