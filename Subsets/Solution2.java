import java.util.*;

public class Solution2 {
	public List<List<Integer>> subsets(int[] nums) {
		if (nums == null) {
			return null;
		}
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>()); //empty set

		/*
			how to do this without backtrack?
			in fact, whenever we add a new number, we add it to all the previous sets
			meanwhile keep all the previous ones
		*/
		for (int i = 0; i < nums.length; i++) {
			int size = res.size();
			for (int j = 0; j < size; j++) {
				ArrayList<Integer> temp = new ArrayList<Integer>(res.get(j));
				temp.add(nums[i]);
				res.add(temp);
			}
		}

		return res;

	}

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = sol.subsets(nums);
        for (List l : res) {
            System.out.println(l);
        }
    }
}