package leetcode;

public class SearchInsertPosition2 {

	public int binarySearch(int[]nums, int target, int start, int end) {
		int mid = start + (end - start) / 2;
		
		if (nums[mid] == target) {
			return mid;
		} else if (target < nums[mid]) {
			return start < mid ? binarySearch(nums, target, start, mid - 1) : start;
		} else {
			return mid < end ? binarySearch(nums, target, mid + 1, end): end + 1;
		}
	}
	public int searchInsert(int[] nums, int target) {
		//edge
		if (nums == null || nums.length == 0) return 0;
		
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition s = new SearchInsertPosition();
		int[] nums = {1, 3, 5, 6};
		int r = s.searchInsert(nums, 7);
		System.out.println(r);
	}
}
