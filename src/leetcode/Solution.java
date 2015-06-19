package leetcode;

import java.util.HashMap;

public class Solution {
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
			System.out.println(n + "|"+i);
			if (n != null && n <= i) {
				res[0] = n;
				res[1] = i + 1;
				break;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,2,4};
		Solution sol = new Solution();
		int ret[] = sol.twoSum(nums, 6);
		System.out.println(ret[0] + "|" + ret[1]);
	}	
	
}

