package leetcode;

import java.util.Arrays;

/* Sort first, and then use two index to find the pair
 * One start from the front, and the other from the tail 
 */

public class TwoSum2 {
	class pair implements Comparable<pair> {
		int number;
		int index;
		
		pair (int number, int index) {
			this.number = number;
			this.index = index;
		}
		
		public int compareTo(pair p2) {
			return this.number - p2.number;
		}
	}
	
	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		int index1 = 0;
		int index2 = nums.length - 1;
		pair[] pairs = new pair[nums.length];
		for (int i = 0; i < nums.length; i++) {
			pairs[i] = new pair(nums[i], i + 1);
		}
		Arrays.sort(pairs);
		
		while(index1 < index2) {
			if ((pairs[index1].number + pairs[index2].number) < target) {
				index1++;
			} else if ((pairs[index1].number + pairs[index2].number > target)) {
					index2--;
			} else {
				if (pairs[index1].index < pairs[index2].index) {
					res[0] = pairs[index1].index;
					res[1] = pairs[index2].index;
				} else {
					res[1] = pairs[index1].index;
					res[0] = pairs[index2].index;					
				}
			}
		}
		
		return res;
	}
	
}
