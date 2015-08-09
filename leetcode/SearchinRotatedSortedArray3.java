package leetcode;

public class SearchinRotatedSortedArray3 {

	public int search(int[] nums, int target) {
		//edge cases
		if (nums == null || nums.length == 0) return -1;
		int left = 0;
		int right = nums.length - 1;
		int mid = left + (right - left) / 2;
		
		while (left <= right) {
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] > nums[left]) {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchinRotatedSortedArray2 s = new SearchinRotatedSortedArray2();
		int[] nums = {1, 3};
		int r = s.search(nums, 2);
		System.out.println(r);
	}

}
