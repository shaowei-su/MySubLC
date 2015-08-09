package leetcode;

import java.util.Arrays;

public class SearchinRotatedSortedArray2 {
	
	public int binarySearch(int[] nums, int target, int left, int right) {
		if (left > right) return -1;
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		
		if (nums[mid] >= nums[left]) {
			if (nums[mid] > target && target >= nums[left]) {
				return binarySearch(nums, target, left, mid - 1);
			} else {
				return binarySearch(nums, target, mid + 1, right);
			}
		} else {
			if (nums[mid] < target && target <= nums[right]) {
				return binarySearch(nums, target, mid + 1, right);
			} else {
				return binarySearch(nums, target, left, mid - 1);
			}
		}
	}
	public int search(int[] nums, int target) {
		//edge cases
		if (nums == null || nums.length == 0) return -1;
		
		return binarySearch(nums, target, 0, nums.length - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchinRotatedSortedArray2 s = new SearchinRotatedSortedArray2();
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int r = s.search(nums, 8);
		System.out.println(r);
	}

}
