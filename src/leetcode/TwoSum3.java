package leetcode;

import java.util.*;

/* by hashtable, iteratively put inputs to the hashtable until pair successfully
 * ? why no duplication
 */
public class TwoSum3 {
	public int[] twoSum(int[] nums, int target) {
		int res[] = new int[2];
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			//put non-duplicate value
			Integer n = table.get(nums[i]);
			if (n == null) {
				table.put(nums[i], i + 1);
			}
			n = table.get(target - nums[i]);
			if (n != null && n < i) {
				res[0] = n;
				res[1] = i + 1;
				break;
			}
		}
		return res;
	}

}
