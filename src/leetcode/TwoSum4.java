package leetcode;

import java.util.Arrays;

/* copy new array to find the number
 * then find the index of these numbers
 */
public class TwoSum4 {
	public int[] twoSum(int[] nums, int target) {
		int N = nums.length;
		int [] sorted = new int[N];
		System.arraycopy(nums, 0, sorted, 0, N);
		Arrays.sort(sorted);
		
		//find the two numbers
		int first = 0;
		int second = sorted.length - 1;
		while (first < second) {
			if (sorted[first] + sorted[second] <target) {
				first++;
				continue;
			} else if (sorted[first] + sorted[second] > target) {
				second--;
				continue;
			} else {
				break;
			}
		}
		int num1 = sorted[first];
		int num2 = sorted[second];
		
		//then find the corresponding indexes
		int index1 = -1; 
		int index2 = -1;
		for (int i = 0; i < N; i++) {
			if ((nums[i] == num1) || (nums[i] == num2)) {
				if (index1 == -1) {
					index1 = i + 1;
				} else {
					index2 = i + 1;
				}
			}
		}
		
		int res[] = new int[2];
		res[0] = index1;
		res[1] = index2;
		return res;
	}
}
